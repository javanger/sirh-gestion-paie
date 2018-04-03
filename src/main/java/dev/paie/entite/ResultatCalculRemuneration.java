/**
 * 
 */
package dev.paie.entite;

/**
 * @author Emmanuel
 *
 */
public class ResultatCalculRemuneration {

	private String salaireDeBase;
	private String salaireBrut;
	private String totalRetenueSalarial;
	private String totalCotisationsPatronales;
	private String netImposable;
	private String netAPayer;
	
	/** Getter
	 * @return the salaireDeBase
	 */
	public String getSalaireDeBase() {
		return salaireDeBase;
	}
	/** Getter
	 * @return the salaireBrut
	 */
	public String getSalaireBrut() {
		return salaireBrut;
	}
	/** Getter
	 * @return the totalRetenueSalarial
	 */
	public String getTotalRetenueSalarial() {
		return totalRetenueSalarial;
	}
	/** Getter
	 * @return the totalCotisationsPatronales
	 */
	public String getTotalCotisationsPatronales() {
		return totalCotisationsPatronales;
	}
	/** Getter
	 * @return the netImposable
	 */
	public String getNetImposable() {
		return netImposable;
	}
	/** Getter
	 * @return the netAPayer
	 */
	public String getNetAPayer() {
		return netAPayer;
	}
	/** Setter
	 * @param salaireDeBase the salaireDeBase to set
	 */
	public void setSalaireDeBase(String salaireDeBase) {
		this.salaireDeBase = salaireDeBase;
	}
	/** Setter
	 * @param salaireBrut the salaireBrut to set
	 */
	public void setSalaireBrut(String salaireBrut) {
		this.salaireBrut = salaireBrut;
	}
	/** Setter
	 * @param totalRetenueSalarial the totalRetenueSalarial to set
	 */
	public void setTotalRetenueSalarial(String totalRetenueSalarial) {
		this.totalRetenueSalarial = totalRetenueSalarial;
	}
	/** Setter
	 * @param totalCotisationsPatronales the totalCotisationsPatronales to set
	 */
	public void setTotalCotisationsPatronales(String totalCotisationsPatronales) {
		this.totalCotisationsPatronales = totalCotisationsPatronales;
	}
	/** Setter
	 * @param netImposable the netImposable to set
	 */
	public void setNetImposable(String netImposable) {
		this.netImposable = netImposable;
	}
	/** Setter
	 * @param netAPayer the netAPayer to set
	 */
	public void setNetAPayer(String netAPayer) {
		this.netAPayer = netAPayer;
	}

}
