package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Grade {

	/** id : int */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** code : String */
	@Column(name = "CODE", length = 15)
	private String code;
	
	/** nbHeuresBase : BigDecimal */
	@Column(name = "NBHEURESBASE", length = 5)
	private BigDecimal nbHeuresBase;
	
	/** tauxBase : BigDecimal */
	@Column(name = "TAUXBASE", length = 5)
	private BigDecimal tauxBase;
	
	public Grade(String unCode, BigDecimal unNbheuresBase, BigDecimal unTauxBase) {
		this.code = unCode;
		this.nbHeuresBase = unNbheuresBase;
		this.tauxBase = unTauxBase;
	}
	
	public Grade() {
		// Constructeur vide
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
