package dev.paie.entite;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "PROFIL_REMUNERATION")
public class ProfilRemuneration {

	/**id : Integer*/
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/**code : String*/
	@Column(name = "CODE", length = 20, nullable = true)
	private String code;
	/**cotisationsNonImposables : List<Cotisation>*/
	@ManyToMany
	@JoinTable(name = "COTISATION_NON_IMPOSABLE",
		joinColumns = @JoinColumn(name = "ID_PROFIL", referencedColumnName = "ID"),
		inverseJoinColumns = @JoinColumn(name = "ID_NON_IMPOSABLE", referencedColumnName= "ID"))
	@OrderBy("code ASC")
	private Set<Cotisation> cotisationsNonImposables;
	
	/**cotisationsImposables : List<Cotisation>*/
	@ManyToMany
	@JoinTable(name = "COTISATION_IMPOSABLE",
		joinColumns = @JoinColumn(name = "ID_PROFIL", referencedColumnName = "ID"),
		inverseJoinColumns = @JoinColumn(name = "ID_IMPOSABLE", referencedColumnName= "ID"))
	@OrderBy("code ASC")
	private Set<Cotisation> cotisationsImposables;
	
	/**avantages : List<Avantage>*/
	@ManyToMany
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
	public Set<Cotisation> getCotisationsNonImposables() {
		return cotisationsNonImposables;
	}

	/** Setter
	 * @param cotisationsNonImposables the cotisationsNonImposables to set
	 */
	public void setCotisationsNonImposables(Set<Cotisation> cotisationsNonImposables) {
		this.cotisationsNonImposables = cotisationsNonImposables;
	}

	/** Getter
	 * @return the cotisationsImposables
	 */
	public Set<Cotisation> getCotisationsImposables() {
		return cotisationsImposables;
	}

	/** Setter
	 * @param cotisationsImposables the cotisationsImposables to set
	 */
	public void setCotisationsImposables(Set<Cotisation> cotisationsImposables) {
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
