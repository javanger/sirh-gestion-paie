/**
 * 
 */
package dev.paie.entite;

/**
 * @author Gobert Guillaume
 *
 */
public class CotisationCalculer extends Cotisation {

	private Cotisation cotisation;
	private String montantSalarial;
	private String cotisationPatronal;

	public Cotisation getCotisation() {
		return cotisation;
	}
	public void setCotisation(Cotisation cotisation) {
		this.cotisation = cotisation;
	}

	public String getMontantSalarial() {
		return montantSalarial;
	}

	public void setMontantSalarial(String string) {
		this.montantSalarial = string;
	}

	public String getCotisationPatronal() {
		return cotisationPatronal;
	}

	public void setCotisationPatronal(String cotisationPatronal) {
		this.cotisationPatronal = cotisationPatronal;
	}

}
