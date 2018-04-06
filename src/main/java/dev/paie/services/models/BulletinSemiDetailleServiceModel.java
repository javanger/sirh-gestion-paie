/**
 * 
 */
package dev.paie.services.models;

import dev.paie.entites.BulletinSalaire;

/**
 * @author Kevin M.
 *
 */

public class BulletinSemiDetailleServiceModel {

	/** bulletinSalaire : BulletinSalaire */
	private BulletinSalaire bulletinSalaire;
	/**
	 * resultatCalculRemunerationServiceModel :
	 * ResultatCalculRemunerationServiceModel
	 */
	private ResultatCalculRemunerationServiceModel resultatCRSM;

	/** dateCreation : String */
	private String dateCreation;
	/** periode : String */
	private String periode;

	/**
	 * Constructor
	 * 
	 */
	public BulletinSemiDetailleServiceModel(BulletinSalaire b, String dateCreation, String periode, ResultatCalculRemunerationServiceModel resultat) {
		this.bulletinSalaire = b;
		this.dateCreation = dateCreation;
		this.periode = periode;
		this.resultatCRSM = resultat;
	}

	/**
	 * Getter
	 * 
	 * @return the dateCreation
	 */
	public String getDateCreation() {
		return dateCreation;
	}

	/**
	 * Setter
	 * 
	 * @param dateCreation
	 *            the dateCreation to set
	 */
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	/**
	 * Getter
	 * 
	 * @return the periode
	 */
	public String getPeriode() {
		return periode;
	}

	/**
	 * Setter
	 * 
	 * @param periode
	 *            the periode to set
	 */
	public void setPeriode(String periode) {
		this.periode = periode;
	}

	/**
	 * Getter
	 * 
	 * @return the bulletinSalaire
	 */
	public BulletinSalaire getBulletinSalaire() {
		return bulletinSalaire;
	}

	/**
	 * Setter
	 * 
	 * @param bulletinSalaire
	 *            the bulletinSalaire to set
	 */
	public void setBulletinSalaire(BulletinSalaire bulletinSalaire) {
		this.bulletinSalaire = bulletinSalaire;
	}

	/**
	 * Getter
	 * 
	 * @return the resultatCRSM
	 */
	public ResultatCalculRemunerationServiceModel getResultatCRSM() {
		return resultatCRSM;
	}

	/**
	 * Setter
	 * 
	 * @param resultatCRSM
	 *            the resultatCRSM to set
	 */
	public void setResultatCRSM(ResultatCalculRemunerationServiceModel resultatCRSM) {
		this.resultatCRSM = resultatCRSM;
	}


}
