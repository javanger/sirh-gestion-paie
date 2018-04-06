package dev.paie.entite;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "RemunerationEmploye")
public class RemunerationEmploye {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "MATRICULE", length = 20)
	private String matricule;
	
	@ManyToOne
	private Entreprise entreprise;
	
	@ManyToOne
	private ProfilRemuneration profilRemuneration;
	
	@ManyToOne
	private Grade grade;
	
	@Column(name = "creation")
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

	/**
	 * Getter
	 * 
	 * @return the creation
	 */
	public String getCreation() {
		return creation.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	}

	public void creationString(ZonedDateTime creation) {
		this.creation = creation;
	}

	/**
	 * Setter
	 * 
	 * @param creation
	 *            the creation to set+
	 */
	public void setCreation(ZonedDateTime dateCreation) {
		this.creation = dateCreation;
	}

	@PrePersist
	public void onPrePersist() {
		setCreation(ZonedDateTime.now());
	}



}
