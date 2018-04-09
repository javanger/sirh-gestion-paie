package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import dev.paie.util.PaieUtils;

@Entity
@Table(name = "Grade")
public class Grade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "CODE", length = 20, nullable = true)
	private String code;
	
	@Column(name = "NB_HEURE_BASE", nullable = true)
	private BigDecimal nbHeuresBase;
	
	@Column(name = "TAUX_BASE", nullable = true)
	private BigDecimal tauxBase;
	
	public String calculerSalaire() {
		PaieUtils paie = new PaieUtils();
		String salaire = paie.formaterBigDecimalArrondi(nbHeuresBase.multiply(tauxBase).multiply(new BigDecimal("12")));

		return salaire;

	}

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
	
	

}
