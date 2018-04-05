package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.*;



@Entity
@Table(name="BULLETINSALAIRE")
public class BulletinSalaire {
	/** id : Integer
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/** remunerationEmploye : RemunerationEmploye
	 * 
	 */
	@ManyToOne
	
	private RemunerationEmploye remunerationEmploye;
	/** periode : Periode
	 * 
	 */
	@ManyToOne
	private Periode periode;
	
	/** primeExceptionnelle : BigDecimal
	 * 
	 */
	@Column(name = "PRIMEEXCEPTIONELLE")
	private BigDecimal primeExceptionnelle;
	
	public BulletinSalaire(){
		
	}
	public RemunerationEmploye getRemunerationEmploye() {
		return remunerationEmploye;
	}
	public void setRemunerationEmploye(RemunerationEmploye remunerationEmploye) {
		this.remunerationEmploye = remunerationEmploye;
	}
	public Periode getPeriode() {
		return periode;
	}
	public void setPeriode(Periode periode) {
		this.periode = periode;
	}
	public BigDecimal getPrimeExceptionnelle() {
		return primeExceptionnelle;
	}
	public void setPrimeExceptionnelle(BigDecimal primeExceptionnelle) {
		this.primeExceptionnelle = primeExceptionnelle;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
