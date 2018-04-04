package dev.paie.entite;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
