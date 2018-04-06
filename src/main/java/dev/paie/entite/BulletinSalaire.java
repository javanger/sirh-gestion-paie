package dev.paie.entite;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "BULLETINSALAIRE")
public class BulletinSalaire {
	/**
	 * id : Integer
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	/**
	 * remunerationEmploye : RemunerationEmploye
	 * 
	 */
	@OneToOne
	private RemunerationEmploye remunerationEmploye;
	/**
	 * periode : Periode
	 * 
	 */
	@ManyToOne
	private Periode periode;

	/**
	 * primeExceptionnelle : BigDecimal
	 * 
	 */
	@Column(name = "PRIMEEXCEPTIONELLE")
	private BigDecimal primeExceptionnelle;

	private ZonedDateTime creation;

	public BulletinSalaire() {

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
