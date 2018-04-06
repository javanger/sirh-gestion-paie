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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	@Column(name="CODE",unique=true)
	private String code;
	@ManyToMany
	@JoinTable(name="PROFIL_COTISATION_NON_IMPOSABLES",
			joinColumns = @JoinColumn(name="profil_id", referencedColumnName="ID"),
			inverseJoinColumns = @JoinColumn(name="cotisation_non_imposable_id", referencedColumnName="ID"))
	@OrderBy("CODE ASC")
	private Set<Cotisation> cotisationsNonImposables;
	@ManyToMany
	@JoinTable(name="PROFIL_COTISATION_IMPOSABLES",
			joinColumns = @JoinColumn(name="profil_id", referencedColumnName="ID"),
			inverseJoinColumns = @JoinColumn(name="cotisation_imposable_id", referencedColumnName="ID"))
	@OrderBy("CODE ASC")
	private Set<Cotisation> cotisationsImposables;
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
