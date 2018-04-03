package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cotisation")
 public class Cotisation {
 	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	private Integer id;
	
	@Column(name = "CODE", length = 20, nullable = false)
 	private String code;
	
	@Column(name = "LIBELLE", length = 50, nullable = false)
 	private String libelle;
	
	@Column(name = "TAUX_SALARIALE", nullable = false)
 	private BigDecimal tauxSalarial;
	
	@Column(name = "TAUX_PATRONAL", nullable = false)
 	private BigDecimal tauxPatronal;
	
	/** Constructor
	 * @param code
	 * @param libelle
	 * @param tauxSalarial
	 * @param tauxPatronal
	 */
	public Cotisation(String code, String libelle, BigDecimal tauxSalarial, BigDecimal tauxPatronal) {
		this.code = code;
		this.libelle = libelle;
		this.tauxSalarial = tauxSalarial;
		this.tauxPatronal = tauxPatronal;
	}
	
	public Cotisation() {
		// Constructeur vide
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
