/**
 * 
 */
package dev.paie.service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.entite.Grade;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

/**
 * @author GOBERT Guillaume
 *
 */
@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {

	@Autowired
	PaieUtils paieUtils;

	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		ResultatCalculRemuneration resultatCalculRemunaration = new ResultatCalculRemuneration();
		Grade grade = bulletin.getRemunerationEmploye().getGrade();
		BigDecimal prime = bulletin.getPrimeExceptionnelle();
		String salaireBaseString = paieUtils.formaterBigDecimal(grade.getNbHeuresBase().multiply(grade.getTauxBase()));
		BigDecimal salaireBase = new BigDecimal(salaireBaseString);
		BigDecimal salaireBrut = salaireBase.add(prime);
		resultatCalculRemunaration.setSalaireDeBase(salaireBase.toString());
		resultatCalculRemunaration.setSalaireBrut(paieUtils.formaterBigDecimal(salaireBrut));
		Set<Cotisation> cotisationsNonImposable = bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsNonImposables();

		Optional<BigDecimal> totalRetenueSalarial = bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsNonImposables().stream().filter(cotisation -> cotisation.getTauxSalarial() != null)
				.map(cotisation -> cotisation.getTauxSalarial().multiply(salaireBrut))
				.reduce((total, taux) -> total.add(taux));
		
		resultatCalculRemunaration.setTotalRetenueSalarial(paieUtils.formaterBigDecimal(totalRetenueSalarial.get()).toString());
		
		Optional<BigDecimal> totalCotisationPatronal = bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsNonImposables().stream().filter(cotisation -> cotisation.getTauxPatronal() != null)
				.map(cotisation -> cotisation.getTauxPatronal().multiply(salaireBrut))
				.reduce((total, taux) -> total.add(taux));
		
		resultatCalculRemunaration.setTotalCotisationsPatronales(paieUtils.formaterBigDecimal(totalCotisationPatronal.get()).toString());
		
		String salaireArrondi = paieUtils.formaterBigDecimal(salaireBrut);
		String retenueSalarialArrondi = paieUtils.formaterBigDecimal(totalRetenueSalarial.get());
		BigDecimal salaire = new BigDecimal(salaireArrondi);
		BigDecimal retenuSalaire = new BigDecimal(retenueSalarialArrondi);
		BigDecimal netImposable = salaire.subtract(retenuSalaire);
				
		resultatCalculRemunaration.setNetImposable(paieUtils.formaterBigDecimal(netImposable).toString());
		
		BigDecimal netAPayer = netImposable.subtract((bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsImposables().stream().filter(cotisation -> cotisation.getTauxSalarial() != null)
				.map(cotisation -> cotisation.getTauxSalarial().multiply(salaireBrut))
				.reduce((total, taux) -> total.add(taux))).get());
		
		resultatCalculRemunaration.setNetAPayer(paieUtils.formaterBigDecimal(netAPayer).toString());

		return resultatCalculRemunaration;
	}
}
