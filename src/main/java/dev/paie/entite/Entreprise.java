package dev.paie.entite;

import javax.persistence.*;

@Entity
@Table(name="ENTREPRISE")
public class Entreprise {

	/** id : Integer
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/** siret : String
	 * 
	 */
	@Column(name = "SIRET")
	private String siret;
	/** denomination : String
	 * 
	 */
	@Column(name = "DENOMINATION")
	private String denomination;
	/** adresse : String
	 * 
	 */
	@Column(name = "ADRESSE")
	private String adresse;
	/** urssaf : String
	 * 
	 */
	@Column(name = "URSSAF")
	private String urssaf;
	/** codeNaf : String
	 * 
	 * @Column(name = "CODENAF")
	 */
	private String codeNaf;
	
	public Entreprise(){
		
	}
	
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getSiret() {
		return siret;
	}
	public void setSiret(String siret) {
		this.siret = siret;
	}
	public String getUrssaf() {
		return urssaf;
	}
	public void setUrssaf(String urssaf) {
		this.urssaf = urssaf;
	}
	public String getCodeNaf() {
		return codeNaf;
	}
	public void setCodeNaf(String codeNaf) {
		this.codeNaf = codeNaf;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
