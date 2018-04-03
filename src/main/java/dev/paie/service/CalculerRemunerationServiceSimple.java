package dev.paie.service;


import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {


	@Autowired
	private PaieUtils paieUtils;
	
	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		ResultatCalculRemuneration resultat = new ResultatCalculRemuneration();
		
		/**
		 * 
		 * calcul salaire brut
		 */
		BigDecimal salaireBrut = (bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase()
				.multiply(bulletin.getRemunerationEmploye().getGrade().getTauxBase())
				.add(bulletin.getPrimeExceptionnelle()));
		
		
				
		resultat.setSalaireBrut(paieUtils.formaterBigDecimal(salaireBrut));
		
        /**
         * calcul total Retenue salaire
         */
		Optional<BigDecimal> totalRetenuesalaire = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables().stream()
				.filter(p -> p.getTauxSalarial() != null )
				.map(p -> p.getTauxSalarial().multiply(salaireBrut))
				.reduce((b1, b2) -> b1.add(b2));
		
		resultat.setTotalRetenueSalarial(paieUtils.formaterBigDecimal(totalRetenuesalaire.get()));
		
		/**
		 * calcul tatoal cotisation patronales
		 */
		Optional<BigDecimal> totalCotisationsPatronales = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables().stream()
				.filter(p -> p.getTauxPatronal() != null)
				.map(p -> p.getTauxPatronal().multiply(salaireBrut))
				.reduce((b1, b2) -> b1.add(b2));
		
		resultat.setTotalCotisationsPatronales(paieUtils.formaterBigDecimal(totalCotisationsPatronales.get()));
		
		/**
		 *  calacul net impossable
		 */
		BigDecimal netImpossable = (salaireBrut.subtract(totalRetenuesalaire.get()));
		resultat.setNetImposable(paieUtils.formaterBigDecimal(netImpossable));
		
		String salaireBrutArr = paieUtils.formaterBigDecimal(salaireBrut);
		BigDecimal salaireBrutArrondi = new BigDecimal(salaireBrutArr);
		
		String totalRetenueSalarialArr = paieUtils.formaterBigDecimal(totalRetenuesalaire.get());
		BigDecimal totalRetenueSalarialArrondi = new BigDecimal(totalRetenueSalarialArr);
		
		BigDecimal netImposable = salaireBrutArrondi.subtract(totalRetenueSalarialArrondi);
		
		resultat.setNetImposable(paieUtils.formaterBigDecimal(netImposable));
		
		
		Optional<BigDecimal> somme = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables().stream()
				.filter(p -> p.getTauxSalarial() != null )
				.map(p -> p.getTauxSalarial().multiply(salaireBrut))
				.reduce((b1, b2) -> b1.add(b2));
		/**
		 * calcul net à payer
		 */
		resultat.setNetAPayer(paieUtils.formaterBigDecimal(netImpossable.subtract(somme.get())));
	return resultat;	
	}
	

}
