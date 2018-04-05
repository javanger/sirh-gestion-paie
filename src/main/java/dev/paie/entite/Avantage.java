package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AVANTAGE")
public class Avantage {

	/**id : Integer*/
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/**code : String*/
	@Column(name = "CODE", length = 20, nullable = true)
	private String code;
	/**nom : String*/
	@Column(name = "NOM", length = 50)
	private String nom;
	/**montant : BigDecimal*/
	@Column(name = "MONTANT")
	private BigDecimal montant;
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
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/** Getter
	 * @return the montant
	 */
	public BigDecimal getMontant() {
		return montant;
	}
	/** Setter
	 * @param montant the montant to set
	 */
	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}
}
