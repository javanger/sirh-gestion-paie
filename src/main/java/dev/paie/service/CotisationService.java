/**
 * 
 */
package dev.paie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.paie.entite.Cotisation;

/**
 * @author Alexis Darcy
 *
 */
@Service
public interface CotisationService {
	
	void sauvegarder(Cotisation nouvelleCotisation);

	void mettreAJour(Cotisation cotisation);

	void supprimer(Cotisation cotisation);
	
	List<Cotisation> lister();
	
}