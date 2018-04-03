/**
 * 
 */
package dev.paie.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Grade;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

/**
 * @author Emmanuel
 *
 */
@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {

	PaieUtils paieUtils = new PaieUtils();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * dev.paie.service.CalculerRemunerationService#calculer(dev.paie.entite.
	 * BulletinSalaire)
	 */
	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {

		ResultatCalculRemuneration remuneration = new ResultatCalculRemuneration();
		Grade grade = bulletin.getRemunerationEmploye().getGrade();

		String salaireDeBase = paieUtils.formaterBigDecimal(grade.getNbHeuresBase().multiply(grade.getTauxBase()));

		remuneration.setSalaireDeBase(salaireDeBase);

		String salaireBrut = paieUtils
				.formaterBigDecimal(bulletin.getPrimeExceptionnelle().add(new BigDecimal(salaireDeBase)));

		remuneration.setSalaireBrut(salaireBrut);

		Optional<BigDecimal> totalRetenueSalarialOptional = bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsNonImposables().stream().filter(c -> c.getTauxSalarial() != null)
				.map(c -> c.getTauxSalarial().multiply(new BigDecimal(salaireBrut))).reduce((s1, s2) -> s1.add(s2));

		BigDecimal totalRetenueSalarial = totalRetenueSalarialOptional.get();

		remuneration.setTotalRetenueSalarial(paieUtils.formaterBigDecimal(totalRetenueSalarial));

		
		
		Optional<BigDecimal> totalCotisationsPatriobalesOptional = bulletin.getRemunerationEmploye()
				.getProfilRemuneration().getCotisationsNonImposables().stream().filter(c -> c.getTauxPatronal() != null)
				.map(c -> c.getTauxPatronal().multiply(new BigDecimal(salaireBrut))).reduce((s1, s2) -> s1.add(s2));

		BigDecimal totalCotisationsPatriobales = totalCotisationsPatriobalesOptional.get();

		remuneration.setTotalCotisationsPatronales(paieUtils.formaterBigDecimal(totalCotisationsPatriobales));

		
		
		BigDecimal netImposable = new BigDecimal(salaireBrut).subtract(totalRetenueSalarial).setScale(2,
				RoundingMode.DOWN);

		remuneration.setNetImposable(paieUtils.formaterBigDecimal(netImposable));
		
		
		Optional<BigDecimal> totalCotisationsSalarial = bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsImposables().stream().filter(c -> c.getTauxSalarial() != null)
				.map(c -> c.getTauxSalarial().multiply(new BigDecimal(salaireBrut))).reduce((c1, c2) -> c1.add(c2));

		BigDecimal netAPayer = netImposable.subtract(totalCotisationsSalarial.get());

		remuneration.setNetAPayer(paieUtils.formaterBigDecimal(netAPayer));


		return remuneration;
	}

}
