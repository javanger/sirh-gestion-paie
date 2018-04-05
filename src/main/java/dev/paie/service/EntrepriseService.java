/**
 * 
 */
package dev.paie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.paie.entite.Entreprise;

/**
 * @author Alexis Darcy
 *
 */
@Service
public interface EntrepriseService {
	
	void sauvegarder(Entreprise nouvelleEntreprise);

	void mettreAJour(Entreprise entreprise);

	void supprimer(Entreprise entreprise);
	
	List<Entreprise> lister();
	
}