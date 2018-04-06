package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Grade")
public class Grade {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "CODE", length = 20)
	private String code;
	@Column(name = "NB_HEURES_BASE")
	private BigDecimal nbHeuresBase;
	@Column(name = "TAUX_BASE")
	private BigDecimal tauxBase;
	@Column(name = "SALAIRE")
	private String salaire;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public BigDecimal getNbHeuresBase() {
		return nbHeuresBase;
	}
	public void setNbHeuresBase(BigDecimal nbHeuresBase) {
		this.nbHeuresBase = nbHeuresBase;
	}
	public BigDecimal getTauxBase() {
		return tauxBase;
	}
	public void setTauxBase(BigDecimal tauxBase) {
		this.tauxBase = tauxBase;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the salaire
	 */
	public String getSalaire() {
		return salaire;
	}

	/**
	 * @param salaire
	 *            the salaire to set
	 */
	public void setSalaire(String salaire) {
		this.salaire = salaire;
	}
	
	

}
