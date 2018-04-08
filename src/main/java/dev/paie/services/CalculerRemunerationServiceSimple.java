/**
 * 
 */
package dev.paie.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entites.BulletinSalaire;
import dev.paie.entites.Cotisation;
import dev.paie.services.model.DetailsCotisationServiceModel;
import dev.paie.services.model.ResultatCalculRemunerationServiceModel;
import dev.paie.utils.PaieUtils;

/**
 * @author Kevin M.
 *
 */
@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {

	private PaieUtils paieUtils;
	ResultatCalculRemunerationServiceModel result;

	/**
	 * Constructor
	 * 
	 * @param paieUtils
	 */
	@Autowired
	public CalculerRemunerationServiceSimple(PaieUtils paieUtils) {
		this.paieUtils = paieUtils;
		result = new ResultatCalculRemunerationServiceModel();
	}

	@Override
	public ResultatCalculRemunerationServiceModel calculer(BulletinSalaire bulletin) {

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



		// details montant salarial par cotisation non imposable
		result.setListMontantParCotisationNonImposable(
				calculerMontantParCotisation(cotisationsNonImposables));

		List<Cotisation> cotisationsImposables = bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsImposables();

		result.setTotalCotisationsPatronales(paieUtils.formaterBigDecimal(totalCotisationsPatronales));

		// details montant salarial par cotisation imposable
		result.setListMontantParCotisationImposable(
				calculerMontantParCotisation(cotisationsImposables));

		// TOTAL_COTISATIONS_Imposables =

		BigDecimal totalCotisationsImposables = result.getListMontantParCotisationImposable().stream()
				.map(v -> new BigDecimal(v.getMontantSalarialParCotisation()))
				.reduce(BigDecimal::add).orElse(new BigDecimal("0.0"));

		result.setTotalCotisationsImposable(paieUtils.formaterBigDecimal(totalCotisationsImposables));

		return result;
	}

	private List<DetailsCotisationServiceModel> calculerMontantParCotisation(List<Cotisation> cotisations) {
		List<DetailsCotisationServiceModel> details = new ArrayList<>();
		cotisations.forEach(c -> {
			DetailsCotisationServiceModel detailsCotisation =  new DetailsCotisationServiceModel();
			detailsCotisation.setCotisation(c);
			detailsCotisation.setMontantPatronaleParCotisation(calculerMontantCotisationPatronale(c));
			detailsCotisation.setMontantSalarialParCotisation(calculerMontantCotisationSalarial(c));
			details.add(detailsCotisation);
		});
		return details;
	}

	private String calculerMontantCotisationSalarial(Cotisation cotisation) {
		BigDecimal base = new BigDecimal(result.getSalaireBrut());
		if (cotisation.getTauxSalarial() != null)
			return paieUtils.formaterBigDecimal(cotisation.getTauxSalarial().multiply(base));
		return "0.0";
	}

	private String calculerMontantCotisationPatronale(Cotisation cotisation) {
		BigDecimal base = new BigDecimal(result.getSalaireBrut());
		if (cotisation.getTauxPatronal() != null)
			return paieUtils.formaterBigDecimal(cotisation.getTauxPatronal().multiply(base));
		return "0.0";
	}
}
