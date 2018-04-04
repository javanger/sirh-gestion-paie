package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COTISATION")
public class Cotisation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	/**
	 * code : String
	 * 
	 */
	@Column(name = "CODE")
	private String code;
	/**
	 * libelle : String
	 * 
	 */
	@Column(name = "LIBELLE")
	private String libelle;
	/**
	 * tauxSalarial : BigDecimal
	 * 
	 */
	@Column(name = "TAUXSALARIAL")
	private BigDecimal tauxSalarial;
	/**
	 * tauxPatronal : BigDecimal
	 * 
	 */
	@Column(name = "TAUXPATRONAL")
	private BigDecimal tauxPatronal;

	public Cotisation() {

	}

	@Override
	public String toString() {
		return "Cotisation [code= " + code + ", libelle= " + libelle + ", tauxSalarial= " + tauxSalarial
				+ ", tauxPatronal= " + tauxPatronal + "]";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public BigDecimal getTauxSalarial() {
		return tauxSalarial;
	}

	public void setTauxSalarial(BigDecimal tauxSalarial) {
		this.tauxSalarial = tauxSalarial;
	}

	public BigDecimal getTauxPatronal() {
		return tauxPatronal;
	}

	public void setTauxPatronal(BigDecimal tauxPatronal) {
		this.tauxPatronal = tauxPatronal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
