/**
 * 
 */
package dev.paie.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.paie.entite.Cotisation;
import dev.paie.entite.CotisationCalculer;
import dev.paie.repository.CotisationRepository;
import dev.paie.util.PaieUtils;

/**
 * @author GOBERT Guillaume
 *
 */
@Component
public class CotisationCalculerService {

	@Autowired
	CotisationRepository cotisationRepository;
	@Autowired
	PaieUtils paieUtils;

	Cotisation cotisation;

	public List<CotisationCalculer> total(String Salairebrut) {
		List<CotisationCalculer> totalRetenue = new ArrayList<>();

		for (Cotisation cotisation : cotisationRepository.findAll()) {
			CotisationCalculer cotisationCalcul = new CotisationCalculer();
			cotisationCalcul.setCotisation(cotisation);
			BigDecimal montantSalarial = cotisation.getTauxSalarial()
					.multiply(new BigDecimal(Salairebrut));
			cotisationCalcul.setMontantSalarial(paieUtils.formaterBigDecimal(montantSalarial));
			BigDecimal cotisationPatronal = cotisation.getTauxPatronal()
					.multiply(new BigDecimal(Salairebrut));
			cotisationCalcul.setCotisationPatronal(paieUtils.formaterBigDecimal(cotisationPatronal));
			totalRetenue.add(cotisationCalcul);
		}
		return totalRetenue;

	}
}
