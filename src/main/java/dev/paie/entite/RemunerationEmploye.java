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
@Table(name = "REMUNERATION_EMPLOYE")
public class RemunerationEmploye {
	
	/**id : Integer*/
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/**matricule : String*/
	@Column(name = "MATRICULE", length = 20, nullable = true)
	private String matricule;
	/**entreprise : Entreprise*/
	@ManyToOne
	private Entreprise entreprise;
	/**profilRemuneration : ProfilRemuneration*/
	@ManyToOne
	private ProfilRemuneration profilRemuneration;
	/**grade : Grade*/
	@ManyToOne
	private Grade grade;
	@Column(name = "DATE_CREATION", length = 20, nullable = true)
	private ZonedDateTime dateCreation;
	
	/** Getter
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/** Setter
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/** Getter
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}
	/** Setter
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	/** Getter
	 * @return the entreprise
	 */
	public Entreprise getEntreprise() {
		return entreprise;
	}
	/** Setter
	 * @param entreprise the entreprise to set
	 */
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	/** Getter
	 * @return the profilRemuneration
	 */
	public ProfilRemuneration getProfilRemuneration() {
		return profilRemuneration;
	}
	/** Setter
	 * @param profilRemuneration the profilRemuneration to set
	 */
	public void setProfilRemuneration(ProfilRemuneration profilRemuneration) {
		this.profilRemuneration = profilRemuneration;
	}
	/** Getter
	 * @return the grade
	 */
	public Grade getGrade() {
		return grade;
	}
	/** Setter
	 * @param grade the grade to set
	 */
	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	/**
	 * Getter
	 * @return the dateCreation
	 */
	public ZonedDateTime getDateCreation() {
		return dateCreation;
	}

	public String getDateCreationString() {
		return dateCreation.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	}

	/**
	 * Setter
	 * @param dateCreation
	 *            the dateCreation to set
	 */
	public void setDateCreation(ZonedDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

	@PrePersist
	public void onPrePersist() {
		setDateCreation(ZonedDateTime.now());
	}

}
