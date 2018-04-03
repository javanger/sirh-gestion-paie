package dev.paie.service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService{
	
	@Autowired private PaieUtils paieUtils;

	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		ResultatCalculRemuneration resultat = new ResultatCalculRemuneration();
		
		BigDecimal salaireBrut = (bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase()
				.multiply(
					(bulletin.getRemunerationEmploye().getGrade().getTauxBase()))
					.add(
						bulletin.getPrimeExceptionnelle()));
		
		resultat.setSalaireBrut(paieUtils.formaterBigDecimal(salaireBrut));
		
		Optional<BigDecimal> totalRetenueSalarial = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables().stream()
				.filter(cotisation->cotisation.getTauxSalarial() != null)
				.map(cotisation -> cotisation.getTauxSalarial().multiply(salaireBrut))
				.reduce((b1, b2) -> b1.add(b2));
		
		resultat.setTotalRetenueSalarial((paieUtils.formaterBigDecimal(totalRetenueSalarial.get())));
		
		Optional<BigDecimal> totalCotisationsPatronales = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables().stream()
				.filter(cotisation->cotisation.getTauxPatronal() != null)
				.map(cotisation -> cotisation.getTauxPatronal().multiply(salaireBrut))
				.reduce((b1, b2) -> b1.add(b2));
		
		resultat.setTotalCotisationsPatronales((paieUtils.formaterBigDecimal(totalCotisationsPatronales.get())));
		
		
		/**
		 * Besoin de faire l'arrondi pour que le calcul se fasse sur deux BigDecimal déjà arrondi 
		 */
		String salaireBrutArrondi = paieUtils.formaterBigDecimal(salaireBrut);
		BigDecimal salaireBrutArrondiCalcul = new BigDecimal(salaireBrutArrondi);
		
		String totalRetenueSalarialArrondi = paieUtils.formaterBigDecimal(totalRetenueSalarial.get());
		BigDecimal totalRetenueSalarialArrondiCalcul = new BigDecimal(totalRetenueSalarialArrondi);
		
		BigDecimal netImposable = salaireBrutArrondiCalcul.subtract(totalRetenueSalarialArrondiCalcul);
		
		resultat.setNetImposable(paieUtils.formaterBigDecimal(netImposable));
		
		Optional<BigDecimal> totalCotisationsSalarial = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables().stream()
				.filter(cotisation->cotisation.getTauxSalarial() != null)
				.map(cotisation -> cotisation.getTauxSalarial().multiply(salaireBrut))
				.reduce((b1, b2) -> b1.add(b2));
		
		BigDecimal netAPayer = netImposable.subtract(totalCotisationsSalarial.get());
		
		resultat.setNetAPayer(paieUtils.formaterBigDecimal(netAPayer));
		
		
		return resultat;
	}

	
}
