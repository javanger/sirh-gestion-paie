/**
 * 
 */
package dev.paie.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

/**
 * @author Kevin M.
 *
 */
@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {

	private PaieUtils paieUtils;

	/**
	 * Constructor
	 * 
	 * @param paieUtils
	 */
	@Autowired
	public CalculerRemunerationServiceSimple(PaieUtils paieUtils) {
		this.paieUtils = paieUtils;
	}

	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {

		ResultatCalculRemuneration result = new ResultatCalculRemuneration();

		// SALAIRE_BASE = GRADE.NB_HEURES_BASE * GRADE.TAUX_BASE
		BigDecimal gradeNbHeuresBase = bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase();
		BigDecimal gradeTauxBase = bulletin.getRemunerationEmploye().getGrade().getTauxBase();
		BigDecimal salaireBase = gradeNbHeuresBase.multiply(gradeTauxBase);

		result.setSalaireDeBase(paieUtils.formaterBigDecimal(salaireBase));

		// SALAIRE_BRUT = SALAIRE_BASE + PRIME_EXCEPTIONNELLE
		BigDecimal salaireBrut = salaireBase.add(bulletin.getPrimeExceptionnelle());

		result.setSalaireBrut(paieUtils.formaterBigDecimal(salaireBrut));

		List<Cotisation> cotisationsNonImposables = bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsNonImposables();

		// TOTAL_RETENUE_SALARIALE =
		// SOMME(COTISATION_NON_IMPOSABLE.TAUX_SALARIAL*SALAIRE_BRUT)
		BigDecimal totalRetenueSalariale = cotisationsNonImposables.stream().filter(c -> c.getTauxSalarial() != null)
				.map(c -> c.getTauxSalarial().multiply(salaireBrut)).reduce(BigDecimal::add)
				.orElse(new BigDecimal("0.0"));

		result.setTotalRetenueSalarial(paieUtils.formaterBigDecimal(totalRetenueSalariale));

		// TOTAL_COTISATIONS_PATRONALES =
		// SOMME(COTISATION_NON_IMPOSABLE.TAUX_PATRONAL*SALAIRE_BRUT)
		BigDecimal totalCotisationsPatronales = cotisationsNonImposables.stream()
				.filter(c -> c.getTauxPatronal() != null).map(c -> c.getTauxPatronal().multiply(salaireBrut))
				.reduce(BigDecimal::add).orElse(new BigDecimal("0.0"));

		result.setTotalCotisationsPatronales(paieUtils.formaterBigDecimal(totalCotisationsPatronales));

		// NET_IMPOSABLE = SALAIRE_BRUT - TOTAL_RETENUE_SALARIALE
		BigDecimal netImposable = salaireBrut.subtract(totalRetenueSalariale);
		result.setNetImposable(paieUtils.formaterBigDecimal(netImposable));

		// NET_A_PAYER = NET_IMPOSABLE -
		// SOMME(COTISATION_IMPOSABLE.TAUX_SALARIAL*SALAIRE_BRUT)
		BigDecimal netAPayer = netImposable.subtract(cotisationsNonImposables.stream()
				.filter(c -> c.getTauxSalarial() != null).map(c -> c.getTauxSalarial().multiply(salaireBrut))
				.reduce(BigDecimal::add).orElse(new BigDecimal("0.0")));
		result.setNetAPayer(paieUtils.formaterBigDecimal(netAPayer));

		return result;
	}

}
