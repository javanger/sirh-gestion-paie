/**
 * 
 */
package dev.paie.controller.viewmodel;

import java.math.BigDecimal;

import dev.paie.entite.Cotisation;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

/**
 * @author Alexis Darcy
 *
 */
public class CotisationViewModel extends Cotisation {

	private String montantSalarial;
	private String montantPatronal;

	public CotisationViewModel(Cotisation cotis, ResultatCalculRemuneration resultatCalculRemuneration,
			PaieUtils paieUtils) {
		super(cotis.getId(), cotis.getCode(), cotis.getLibelle(), cotis.getTauxSalarial(), cotis.getTauxPatronal());
		if (cotis.getTauxSalarial() != null) {
			this.setMontantSalarial(paieUtils.formaterBigDecimal(
					cotis.getTauxSalarial().multiply(new BigDecimal(resultatCalculRemuneration.getSalaireBrut()))));
		}
		if (cotis.getTauxPatronal() != null) {
			this.setMontantPatronal(paieUtils.formaterBigDecimal(
					cotis.getTauxPatronal().multiply(new BigDecimal(resultatCalculRemuneration.getSalaireBrut()))));
		}
	}

	/**
	 * Getter
	 * 
	 * @return the montantSalarial
	 */
	public String getMontantSalarial() {
		return montantSalarial;
	}

	/**
	 * Setter
	 * 
	 * @param montantSalarial
	 *            the montantSalarial to set
	 */
	public void setMontantSalarial(String montantSalarial) {
		this.montantSalarial = montantSalarial;
	}

	/**
	 * Getter
	 * 
	 * @return the montantPatronal
	 */
	public String getMontantPatronal() {
		return montantPatronal;
	}


	/**
	 * Setter
	 * 
	 * @param montantPatronal
	 *            the montantPatronal to set
	 */
	public void setMontantPatronal(String montantPatronal) {
		this.montantPatronal = montantPatronal;
	}


}
