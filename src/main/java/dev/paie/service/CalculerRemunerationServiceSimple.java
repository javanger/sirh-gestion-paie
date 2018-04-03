/**
 * 
 */
package dev.paie.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Grade;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

/**
 * @author Axel B.
 *
 */

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {

	@Autowired
	private PaieUtils paieUtils;

	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {

		ResultatCalculRemuneration resultat = new ResultatCalculRemuneration();

		Grade grade = bulletin.getRemunerationEmploye().getGrade();

		BigDecimal salaireDeBase = grade.getTauxBase().multiply(grade.getNbHeuresBase());
		
		resultat.setSalaireDeBase(paieUtils.formaterBigDecimal(salaireDeBase));

		BigDecimal salaireBrut = (bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase().multiply((bulletin.getRemunerationEmploye().getGrade().getTauxBase())).add(bulletin.getPrimeExceptionnelle()));

		resultat.setSalaireBrut(paieUtils.formaterBigDecimal(salaireBrut));
		
		
		Optional<BigDecimal> totalRetenueSalarial = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables().stream()
				.filter(cotisation->cotisation.getTauxSalarial() != null)
				.map(cotisation -> cotisation.getTauxSalarial().multiply(salaireBrut))
				.reduce((b1, b2) -> b1.add(b2));
		
		resultat.setTotalRetenueSalarial((paieUtils.formaterBigDecimal(totalRetenueSalarial.get())));
		
		
		Optional<BigDecimal> totalRetenuePatronales = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables().stream()
				.filter(cotisation->cotisation.getTauxPatronal() != null)
				.map(cotisation -> cotisation.getTauxPatronal().multiply(salaireBrut))
				.reduce((b1, b2) -> b1.add(b2));
		
		resultat.setTotalRetenueSalarial((paieUtils.formaterBigDecimal(totalRetenuePatronales.get())));
		
		
		BigDecimal netImposable = salaireBrut.subtract(totalRetenuePatronales.get());
		

		resultat.setNetImposable(paieUtils.formaterBigDecimal(netImposable));
		
		
		BigDecimal netAPayer = netImposable.subtract((bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables().stream()
				.filter(cotisation->cotisation.getTauxSalarial() != null)
				.map(cotisation -> cotisation.getTauxSalarial().multiply(salaireBrut))
				.reduce((b1, b2) -> b1.add(b2))).get());
	
		

		return resultat;
	}

}
