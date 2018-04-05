package dev.paie.entite;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "REMUNERATIONEMPLOYE")
public class RemunerationEmploye {
	/**
	 * id : Integer
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	/**
	 * matricule : String
	 * 
	 */
	@Column(name = "MATRICULE")
	private String matricule;
	/**
	 * entreprise : Entreprise
	 * 
	 */
	@Column(name = "CREATION")
	private ZonedDateTime creation;

	@ManyToOne
	@JoinColumn(name = "ID_ENTREPRISE")
	private Entreprise entreprise;
	/**
	 * profilRemuneration : ProfilRemuneration
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "ID_PROFILREMUNERATION")
	private ProfilRemuneration profilRemuneration;
	/**
	 * grade : Grade
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "ID_GRADE")
	private Grade grade;

	public RemunerationEmploye() {

	}

	/**
	 * @return the creation
	 */
	public ZonedDateTime getCreation() {
		return creation;
	}

	public String getCreationMois() {
		return creation.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	}

	/**
	 * @param creation
	 *            the creation to set
	 */
	public void setCreation(ZonedDateTime creation) {
		this.creation = creation;
	}

	@PrePersist
	public void onPrePersist() {
		setCreation(ZonedDateTime.now());
	}

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

}
