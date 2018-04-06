package dev.paie.entite;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class RemunerationEmploye {

	/** id : int */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/** matricule : String */
	@Column(name = "MATRICULE", length = 15)
	private String matricule;

	/** entreprise : Entreprise */
	@ManyToOne
	@JoinColumn(name = "ID_ENTREPRISE")
	private Entreprise entreprise;

	/** profilRemuneration : ProfilRemuneration */
	@ManyToOne
	@JoinColumn(name = "ID_PROFILREMUNERATION")
	private ProfilRemuneration profilRemuneration;

	/** grade : Grade */
	@ManyToOne
	@JoinColumn(name = "GRADE")
	private Grade grade;
	
	/** dateCreation : LocalDateTime */
	@Column(name = "DATECREATION")
	private LocalDateTime dateCreation;

	public String getMatricule() {
		return matricule;
	}

	/**
	 * @param matricule
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}
	
	/** Getter
	 * @return the dateCreation
	 */
	public LocalDateTime getDateCreation() {
		return dateCreation;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/** Setter
	 * @param dateCreation the dateCreation to set
	 */
	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

}
