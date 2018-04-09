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
import javax.persistence.OneToMany;

@Entity
public class ProfilRemuneration {

	/** id : int */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/** code : String */
	@Column(name = "CODE", length = 15)
	private String code;

	/** cotisationsNonImposables : List<Cotisation> */
	@ManyToMany
	@JoinTable(name = "COTISATION_NON_IMPOSSABLES", 
	joinColumns = @JoinColumn(name = "ID_PROFIL", referencedColumnName = "ID"), 
	inverseJoinColumns = @JoinColumn(name = "ID_COTISATION", referencedColumnName = "ID"))
	private Set<Cotisation> cotisationsNonImposables;

	/** cotisationsImposables : List<Cotisation> */
	@ManyToMany
	@JoinTable(name = "COTISATION_IMPOSSABLES", 
	joinColumns = @JoinColumn(name = "ID_PROFIL", referencedColumnName = "ID"), 
	inverseJoinColumns = @JoinColumn(name = "ID_COTISATION", referencedColumnName = "ID"))
	private Set<Cotisation> cotisationsImposables;

	/** avantages : List<Avantage> */
	@OneToMany
	private List<Avantage> avantages;

	public ProfilRemuneration() {
		// Constructeur vide
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Set<Cotisation> getCotisationsNonImposables() {
		return cotisationsNonImposables;
	}

	public void setCotisationsNonImposables(Set<Cotisation> cotisationsNonImposables) {
		this.cotisationsNonImposables = cotisationsNonImposables;
	}

	public Set<Cotisation> getCotisationsImposables() {
		return cotisationsImposables;
	}

	public void setCotisationsImposables(Set<Cotisation> cotisationsImposables) {
		this.cotisationsImposables = cotisationsImposables;
	}

	public List<Avantage> getAvantages() {
		return avantages;
	}

	public void setAvantages(List<Avantage> avantages) {
		this.avantages = avantages;
	}

}
