package dev.paie.entite;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="PERIODE")
public class ProfilRemuneration {
	/** id : Integer
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/** code : String
	 * 
	 */
	@Column(name = "CODE")
	private String code;

	/** cotisationsNonImposables : List<Cotisation>
	 * 
	 */
	@ManyToMany
	private List<Cotisation> cotisationsNonImposables;
	
	/** cotisationsImposables : List<Cotisation>
	 * 
	 */
	@ManyToMany
	private List<Cotisation> cotisationsImposables;
	
	/** avantages : List<Avantage>
	 * 
	 */
	@ManyToMany
	private List<Avantage> avantages;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Cotisation> getCotisationsNonImposables() {
		return cotisationsNonImposables;
	}

	public void setCotisationsNonImposables(List<Cotisation> cotisationsNonImposables) {
		this.cotisationsNonImposables = cotisationsNonImposables;
	}

	public List<Cotisation> getCotisationsImposables() {
		return cotisationsImposables;
	}

	public void setCotisationsImposables(List<Cotisation> cotisationsImposables) {
		this.cotisationsImposables = cotisationsImposables;
	}

	public List<Avantage> getAvantages() {
		return avantages;
	}

	public void setAvantages(List<Avantage> avantages) {
		this.avantages = avantages;
	}

}
