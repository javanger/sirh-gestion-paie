/**
 * 
 */
package dev.paie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.paie.entite.Cotisation;

/**
 * @author Axel B.
 *
 */
@Service
public interface CotisationService {

	void sauvegarder(Cotisation nouvelleCotisation);
	
	void mettreAJour(Cotisation cot);

	List<Cotisation> lister();
	/**
	 * @param cotisation
	 */
	void supprimer(Cotisation cotisation);
}
