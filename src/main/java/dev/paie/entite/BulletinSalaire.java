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
import javax.persistence.PrePersist;
import javax.persistence.Table;


@Entity
@Table(name = "BULLETIN_SALAIRE")
public class BulletinSalaire {
	
	/**id : Integer*/
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/**remunerationEmploye : RemunerationEmploye*/
	@ManyToOne
	private RemunerationEmploye remunerationEmploye;
	/**periode : Periode*/
	@ManyToOne
	private Periode periode;
	/**primeExceptionnelle : BigDecimal*/
	@Column(name = "PRIME_EXCEPTIONNELLE")
	private BigDecimal primeExceptionnelle;
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
	 * @return the remunerationEmploye
	 */
	public RemunerationEmploye getRemunerationEmploye() {
		return remunerationEmploye;
	}
	/** Setter
	 * @param remunerationEmploye the remunerationEmploye to set
	 */
	public void setRemunerationEmploye(RemunerationEmploye remunerationEmploye) {
		this.remunerationEmploye = remunerationEmploye;
	}
	/** Getter
	 * @return the periode
	 */
	public Periode getPeriode() {
		return periode;
	}
	/** Setter
	 * @param periode the periode to set
	 */
	public void setPeriode(Periode periode) {
		this.periode = periode;
	}
	/** Getter
	 * @return the primeExceptionnelle
	 */
	public BigDecimal getPrimeExceptionnelle() {
		return primeExceptionnelle;
	}
	/** Setter
	 * @param primeExceptionnelle the primeExceptionnelle to set
	 */
	public void setPrimeExceptionnelle(BigDecimal primeExceptionnelle) {
		this.primeExceptionnelle = primeExceptionnelle;
	}	

	/**
	 * Getter
	 * 
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
	 * 
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
