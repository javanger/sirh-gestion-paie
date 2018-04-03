package dev.paie.entite;

import java.math.BigDecimal;

public class BulletinSalaire {
	
	/**id : Integer*/
	private Integer id;
	/**remunerationEmploye : RemunerationEmploye*/
	private RemunerationEmploye remunerationEmploye;
	/**periode : Periode*/
	private Periode periode;
	/**primeExceptionnelle : BigDecimal*/
	private BigDecimal primeExceptionnelle;
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
	 * @return the remunerationEmploye
	 */
	public RemunerationEmploye getRemunerationEmploye() {
		return remunerationEmploye;
	}
	/** Setter
	 * @param remunerationEmploye the remunerationEmploye to set
	 */
	public void setRemunerationEmploye(RemunerationEmploye remunerationEmploye) {
		this.remunerationEmploye = remunerationEmploye;
	}
	/** Getter
	 * @return the periode
	 */
	public Periode getPeriode() {
		return periode;
	}
	/** Setter
	 * @param periode the periode to set
	 */
	public void setPeriode(Periode periode) {
		this.periode = periode;
	}
	/** Getter
	 * @return the primeExceptionnelle
	 */
	public BigDecimal getPrimeExceptionnelle() {
		return primeExceptionnelle;
	}
	/** Setter
	 * @param primeExceptionnelle the primeExceptionnelle to set
	 */
	public void setPrimeExceptionnelle(BigDecimal primeExceptionnelle) {
		this.primeExceptionnelle = primeExceptionnelle;
	}	

}
