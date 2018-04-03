package dev.paie.entite;

import java.util.List;


public class ProfilRemuneration {

	/**id : Integer*/
	private Integer id;
	/**code : String*/
	private String code;

	/**cotisationsNonImposables : List<Cotisation>*/
	private List<Cotisation> cotisationsNonImposables;
	
	/**cotisationsImposables : List<Cotisation>*/
	private List<Cotisation> cotisationsImposables;
	
	/**avantages : List<Avantage>*/
	private List<Avantage> avantages;

	/** Getter
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/** Setter
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/** Getter
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/** Setter
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/** Getter
	 * @return the cotisationsNonImposables
	 */
	public List<Cotisation> getCotisationsNonImposables() {
		return cotisationsNonImposables;
	}

	/** Setter
	 * @param cotisationsNonImposables the cotisationsNonImposables to set
	 */
	public void setCotisationsNonImposables(List<Cotisation> cotisationsNonImposables) {
		this.cotisationsNonImposables = cotisationsNonImposables;
	}

	/** Getter
	 * @return the cotisationsImposables
	 */
	public List<Cotisation> getCotisationsImposables() {
		return cotisationsImposables;
	}

	/** Setter
	 * @param cotisationsImposables the cotisationsImposables to set
	 */
	public void setCotisationsImposables(List<Cotisation> cotisationsImposables) {
		this.cotisationsImposables = cotisationsImposables;
	}

	/** Getter
	 * @return the avantages
	 */
	public List<Avantage> getAvantages() {
		return avantages;
	}

	/** Setter
	 * @param avantages the avantages to set
	 */
	public void setAvantages(List<Avantage> avantages) {
		this.avantages = avantages;
	}
}
