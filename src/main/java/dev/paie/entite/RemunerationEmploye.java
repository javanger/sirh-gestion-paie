package dev.paie.entite;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "REMUNERATION_EMPLOYE")
public class RemunerationEmploye {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	@Column(name="MATRICULE", unique=true)
	private String matricule;
	@OneToOne
	private Entreprise entreprise;
	@OneToOne
	private ProfilRemuneration profilRemuneration;
	@OneToOne
	private Grade grade;
	@Column(name = "CREATION")
	private ZonedDateTime creation;

	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	public Entreprise getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	public ProfilRemuneration getProfilRemuneration() {
		return profilRemuneration;
	}
	public void setProfilRemuneration(ProfilRemuneration profilRemuneration) {
		this.profilRemuneration = profilRemuneration;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public ZonedDateTime getCreation() {
		return creation;
	}
	public String getCreationString(){
		return creation.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	}
	public void setCreation(ZonedDateTime creation) {
		this.creation = creation;
	}
}
