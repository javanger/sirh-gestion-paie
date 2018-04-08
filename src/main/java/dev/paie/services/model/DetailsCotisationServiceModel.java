/**
 * 
 */
package dev.paie.services.model;

import dev.paie.entites.Cotisation;

/**
 * @author Kevin M.
 *
 */

public class DetailsCotisationServiceModel {


	/** cotisation : Cotisation */
	Cotisation cotisation;
	/** montantSalarialParCotisation : String */
	String montantSalarialParCotisation;
	/** montantPatronaleParCotisation : String */
	String montantPatronaleParCotisation;

	/**
	 * Getter
	 * 
	 * @return the cotisation
	 */
	public Cotisation getCotisation() {
		return cotisation;
	}


	/**
	 * Setter
	 * 
	 * @param cotisation
	 *            the cotisation to set
	 */
	public void setCotisation(Cotisation cotisation) {
		this.cotisation = cotisation;
	}


	/**
	 * Getter
	 * 
	 * @return the montantSalarialParCotisation
	 */
	public String getMontantSalarialParCotisation() {
		return montantSalarialParCotisation;
	}


	/**
	 * Setter
	 * 
	 * @param montantSalarialParCotisation
	 *            the montantSalarialParCotisation to set
	 */
	public void setMontantSalarialParCotisation(String montantSalarialParCotisation) {
		this.montantSalarialParCotisation = montantSalarialParCotisation;
	}


	/**
	 * Getter
	 * 
	 * @return the montantPatronaleParCotisation
	 */
	public String getMontantPatronaleParCotisation() {
		return montantPatronaleParCotisation;
	}


	/**
	 * Setter
	 * 
	 * @param montantPatronaleParCotisation
	 *            the montantPatronaleParCotisation to set
	 */
	public void setMontantPatronaleParCotisation(String montantPatronaleParCotisation) {
		this.montantPatronaleParCotisation = montantPatronaleParCotisation;
	}


}
