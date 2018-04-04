package dev.paie.entite;

import javax.persistence.*;

@Entity
@Table(name="PERIODE")
public class RemunerationEmploye {
	/** id : Integer
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/** matricule : String
	 * 
	 */
	@Column(name = "MATRICULE")
	private String matricule;
	/** entreprise : Entreprise
	 * 
	 */
	@ManyToOne
	private Entreprise entreprise;
	/** profilRemuneration : ProfilRemuneration
	 * 
	 */
	@ManyToOne
	private ProfilRemuneration profilRemuneration;
	/** grade : Grade
	 * 
	 */
	@ManyToOne
	private Grade grade;
	
	public RemunerationEmploye(){
		
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
