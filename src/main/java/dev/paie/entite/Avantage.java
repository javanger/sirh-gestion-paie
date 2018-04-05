package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Avantage {

	/** id : int */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** code : String */
	@Column(name = "CODE", length = 15)
	private String code;

	/** nom : String */
	@Column(name = "NOM", length = 30)
	private String nom;
	
	@Column(name = "MONTANT", length = 10)
	private BigDecimal montant;
	
	public Avantage() {
		// Constructeur vide
	}
	
	/** Constructor
	 * @param code
	 * @param nom
	 * @param montant
	 */
	public Avantage(String code, String nom, BigDecimal montant) {
		this.code = code;
		this.nom = nom;
		this.montant = montant;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public BigDecimal getMontant() {
		return montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
