/**
 * 
 */
package dev.paie.services;

import java.util.List;

import dev.paie.entites.Cotisation;

/**
 * @author Kevin M.
 *
 */
public interface CotisationService {

	void sauvegarder(Cotisation nouvelleCotisation);
	void mettreAjour(Cotisation cotisation);
	List<Cotisation> lister();
}
