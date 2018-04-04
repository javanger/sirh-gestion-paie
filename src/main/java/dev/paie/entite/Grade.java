package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name="GRADE")
public class Grade {
	
	/** id : Integer
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/** code : String
	 * 
	 */
	@Column(name = "CODE")
	private String code;
	/** nbHeuresBase : BigDecimal
	 * 
	 */
	@Column(name = "NBHEURESBASE")
	private BigDecimal nbHeuresBase;
	/** tauxBase : BigDecimal
	 * 
	 */
	@Column(name = "TAUXBASE")
	private BigDecimal tauxBase;
	
	public Grade(){
		
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public BigDecimal getNbHeuresBase() {
		return nbHeuresBase;
	}
	public void setNbHeuresBase(BigDecimal nbHeuresBase) {
		this.nbHeuresBase = nbHeuresBase;
	}
	public BigDecimal getTauxBase() {
		return tauxBase;
	}
	public void setTauxBase(BigDecimal tauxBase) {
		this.tauxBase = tauxBase;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
