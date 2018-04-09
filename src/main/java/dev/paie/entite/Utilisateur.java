package dev.paie.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Emmanuel
 *
 */
@Entity
public class Utilisateur {

	public enum ROLES {
		ROLE_ADMINISTRATEUR, ROLE_UTILISATEUR
	}

	/** id : Integer */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** nomUtilisateur : String */
	@Column(name = "NOM_UTILISATEUR", length = 20)
	private String nomUtilisateur;

	/** motDePasse : String */
	@Column(name = "MOT_DE_PASSE", length = 100)
	private String motDePasse;

	/** estActif : Boolean */
	@Column(name = "EST_ACTIF")
	private Boolean estActif;

	/** role : ROLES */
	@Column(name = "ROLE", length = 20)
	@Enumerated(EnumType.STRING)
	private ROLES role;

	public Utilisateur() {

	}

	/**
	 * Constructor
	 * 
	 * @param nomUtilisateur
	 * @param motDePasse
	 * @param estActif
	 * @param role
	 */
	public Utilisateur(String nomUtilisateur, String motDePasse, Boolean estActif, ROLES role) {
		this.nomUtilisateur = nomUtilisateur;
		this.motDePasse = motDePasse;
		this.estActif = estActif;
		this.role = role;
	}
	
	public Utilisateur(String nomUtilisateur, String motDePasse, Boolean estActif) {
		this.nomUtilisateur = nomUtilisateur;
		this.motDePasse = motDePasse;
		this.estActif = estActif;
	}

	/**
	 * Getter
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Getter
	 * 
	 * @return the nomUtilisateur
	 */
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	/**
	 * Getter
	 * 
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * Getter
	 * 
	 * @return the estActif
	 */
	public Boolean getEstActif() {
		return estActif;
	}

	/**
	 * Getter
	 * 
	 * @return the role
	 */
	public ROLES getRole() {
		return role;
	}

	/**
	 * Setter
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Setter
	 * 
	 * @param nomUtilisateur
	 *            the nomUtilisateur to set
	 */
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	/**
	 * Setter
	 * 
	 * @param motDePasse
	 *            the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	/**
	 * Setter
	 * 
	 * @param estActif
	 *            the estActif to set
	 */
	public void setEstActif(Boolean estActif) {
		this.estActif = estActif;
	}

	/**
	 * Setter
	 * 
	 * @param role
	 *            the role to set
	 */
	public void setRole(ROLES role) {
		this.role = role;
	}

}
