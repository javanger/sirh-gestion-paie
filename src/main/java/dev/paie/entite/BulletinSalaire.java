package dev.paie.entite;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BulletinSalaire {

	/** id : int */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** remunerationEmploye : RemunerationEmploye */
	@ManyToOne
	@JoinColumn(name = "ID_REMNURATIONEMPLOYE")
	private RemunerationEmploye remunerationEmploye;

	/** periode : Periode */
	@ManyToOne
	@JoinColumn(name = "ID_PERIODE")
	private Periode periode;

	/** primeExceptionnelle : BigDecimal */
	@Column(name = "PRIMEEXCEPTIONNELLE", length = 15)
	private BigDecimal primeExceptionnelle;
	
	/** dateCreation : LocalDateTime */
	@Column(name = "DATECREATION")
	private LocalDateTime dateCreation;

	public BulletinSalaire() {
		// Constructeur vide
	}
	
	public RemunerationEmploye getRemunerationEmploye() {
		return remunerationEmploye;
	}

	public void setRemunerationEmploye(RemunerationEmploye remunerationEmploye) {
		this.remunerationEmploye = remunerationEmploye;
	}

	/** Setter
	 * @param dateCreation the dateCreation to set
	 */
	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
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
	
	/** Getter
	 * @return the dateCreation
	 */
	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

}
