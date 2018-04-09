/**
 * 
 */
package dev.paie.services.model;

import java.util.List;

/**
 * @author Kevin M.
 *
 */

public class ResultatCalculRemunerationServiceModel {

	/** salaireDeBase : String */
	private String salaireDeBase;
	/** salaireBrut : String */
	private String salaireBrut;
	/** totalRetenueSalarial : String */
	private String totalRetenueSalarial;
	/** totalCotisationsPatronales : String */
	private String totalCotisationsPatronales;
	/** totalCotisationsImposable : String */
	private String totalCotisationsImposable;
	/** netImposable : String */
	private String netImposable;
	/** netAPayer : String */
	private String netAPayer;
	/**
	 * listMontantParCotisationNonImposable :
	 * List<DetailsCotisationServiceModel>
	 */
	private List<DetailsCotisationServiceModel> listMontantParCotisationNonImposable;
	/**
	 * listMontantParCotisationImposable : List<DetailsCotisationServiceModel>
	 */
	private List<DetailsCotisationServiceModel> listMontantParCotisationImposable;

	/**
	 * Getter
	 * 
	 * @return the salaireDeBase
	 */
	public String getSalaireDeBase() {
		return salaireDeBase;
	}

	/**
	 * Setter
	 * 
	 * @param salaireDeBase
	 *            the salaireDeBase to set
	 */
	public void setSalaireDeBase(String salaireDeBase) {
		this.salaireDeBase = salaireDeBase;
	}

	/**
	 * Getter
	 * 
	 * @return the salaireBrut
	 */
	public String getSalaireBrut() {
		return salaireBrut;
	}

	/**
	 * Setter
	 * 
	 * @param salaireBrut
	 *            the salaireBrut to set
	 */
	public void setSalaireBrut(String salaireBrut) {
		this.salaireBrut = salaireBrut;
	}

	/**
	 * Getter
	 * 
	 * @return the totalRetenueSalarial
	 */
	public String getTotalRetenueSalarial() {
		return totalRetenueSalarial;
	}

	/**
	 * Setter
	 * 
	 * @param totalRetenueSalarial
	 *            the totalRetenueSalarial to set
	 */
	public void setTotalRetenueSalarial(String totalRetenueSalarial) {
		this.totalRetenueSalarial = totalRetenueSalarial;
	}

	/**
	 * Getter
	 * 
	 * @return the totalCotisationsPatronales
	 */
	public String getTotalCotisationsPatronales() {
		return totalCotisationsPatronales;
	}

	/**
	 * Setter
	 * 
	 * @param totalCotisationsPatronales
	 *            the totalCotisationsPatronales to set
	 */
	public void setTotalCotisationsPatronales(String totalCotisationsPatronales) {
		this.totalCotisationsPatronales = totalCotisationsPatronales;
	}

	/**
	 * Getter
	 * 
	 * @return the netImposable
	 */
	public String getNetImposable() {
		return netImposable;
	}

	/**
	 * Setter
	 * 
	 * @param netImposable
	 *            the netImposable to set
	 */
	public void setNetImposable(String netImposable) {
		this.netImposable = netImposable;
	}

	/**
	 * Getter
	 * 
	 * @return the netAPayer
	 */
	public String getNetAPayer() {
		return netAPayer;
	}

	/**
	 * Setter
	 * 
	 * @param netAPayer
	 *            the netAPayer to set
	 */
	public void setNetAPayer(String netAPayer) {
		this.netAPayer = netAPayer;
	}

	/**
	 * Getter
	 * 
	 * @return the listMontantParCotisationNonImposable
	 */
	public List<DetailsCotisationServiceModel> getListMontantParCotisationNonImposable() {
		return listMontantParCotisationNonImposable;
	}

	/**
	 * Setter
	 * 
	 * @param listMontantParCotisationNonImposable
	 *            the listMontantParCotisationNonImposable to set
	 */
	public void setListMontantParCotisationNonImposable(
			List<DetailsCotisationServiceModel> listMontantParCotisationNonImposable) {
		this.listMontantParCotisationNonImposable = listMontantParCotisationNonImposable;
	}

	/**
	 * Getter
	 * 
	 * @return the listMontantParCotisationImposable
	 */
	public List<DetailsCotisationServiceModel> getListMontantParCotisationImposable() {
		return listMontantParCotisationImposable;
	}

	/**
	 * Setter
	 * 
	 * @param listMontantParCotisationImposable
	 *            the listMontantParCotisationImposable to set
	 */
	public void setListMontantParCotisationImposable(
			List<DetailsCotisationServiceModel> listMontantParCotisationImposable) {
		this.listMontantParCotisationImposable = listMontantParCotisationImposable;
	}

	/**
	 * Getter
	 * 
	 * @return the totalCotisationsImposable
	 */
	public String getTotalCotisationsImposable() {
		return totalCotisationsImposable;
	}

	/**
	 * Setter
	 * 
	 * @param totalCotisationsImposable
	 *            the totalCotisationsImposable to set
	 */
	public void setTotalCotisationsImposable(String totalCotisationsImposable) {
		this.totalCotisationsImposable = totalCotisationsImposable;
	}



}
