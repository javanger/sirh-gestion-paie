package dev.paie.entite;

public class RemunerationEmploye {
	
	/**id : Integer*/
	private Integer id;
	/**matricule : String*/
	private String matricule;
	/**entreprise : Entreprise*/
	private Entreprise entreprise;
	/**profilRemuneration : ProfilRemuneration*/
	private ProfilRemuneration profilRemuneration;
	/**grade : Grade*/
	private Grade grade;
	
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
	
}
