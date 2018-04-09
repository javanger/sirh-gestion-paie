/**
 * 
 */
package dev.paie.service;

import java.util.List;

import dev.paie.entite.Cotisation;

/**
 * @author GOBERT Guillaume
 *
 */
public interface CotisationServiceInterface {
	/**
	 * Ajout d'une nouvelle cotisation dans la base
	 * @param nouvelleCotisation Cotisation a enregistrer dans la base
	 */
	void sauvegarder(Cotisation nouvelleCotisation);

	/**
	 * Mise a jour d'une cotisation presente en base
	 * @param cotisation Cotisation a mettre a jour
	 */
	void mettreAJour(Cotisation cotisation);

	/**
	 * Liste les cotisations presnetes en base
	 * @return une liste de cotisation
	 */
	List<Cotisation> lister();
	
	/**
	 * Supprime une cotisation de la base
	 * @param supprimerCotisation Cotisation a supprimer
	 */
	void supprimer(Cotisation supprimerCotisation);
}