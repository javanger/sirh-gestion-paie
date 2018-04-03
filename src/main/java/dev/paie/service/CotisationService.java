/**
 * 
 */
package dev.paie.service;

import java.util.List;

import dev.paie.entite.Cotisation;

/**
 * @author Kevin M.
 *
 */
public interface CotisationService {

	void sauvegarder(Cotisation nouvelleCotisation);
	void mettreAjour(Cotisation cotisation);
	List<Cotisation> lister();
}
