package dev.paie.service;

import java.util.List;

import dev.paie.entite.Cotisation;

/**
 * @author Emmanuel
 *
 */
public interface ICotisationService {
	
	void sauvegarder(Cotisation nouvelleCotisation);

	void mettreAJour(Cotisation cotisation);

	List<Cotisation> lister();
}
