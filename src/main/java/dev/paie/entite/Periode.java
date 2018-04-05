package dev.paie.entite;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERIODE")
public class Periode {
	
	/**id : Integer*/
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/**dateDebut : LocalDate*/
	@Column(name = "DATE_DEBUT")
	private LocalDate dateDebut;
	/**dateFin : LocalDate*/
	@Column(name = "DATE_FIN")
	private LocalDate dateFin;
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
	 * @return the dateDebut
	 */
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	/** Setter
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	/** Getter
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}
	/** Setter
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public String getDateString() {
		return dateDebut.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " - "
				+ dateFin.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
}
