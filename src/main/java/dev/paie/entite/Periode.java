package dev.paie.entite;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="PERIODE")
public class Periode {
	
	/** id : Integer
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** dateDebut : LocalDate
	 * 
	 */
	@Column(name = "DATEDEBUT")
	private LocalDate dateDebut;
	/** dateFin : LocalDate
	 * 
	 */
	@Column(name = "DATEFIN")
	private LocalDate dateFin;
	
	public Periode(){
		
	}
	
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	public LocalDate getDateFin() {
		return dateFin;
	}
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	

}
