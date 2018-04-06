/**
 * 
 */
package dev.paie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.Entreprise;
import dev.paie.repository.EntrepriseRepository;

/**
 * @author Alexis Darcy
 *
 */
@Service
public class EntrepriseServiceDataJpa implements EntrepriseService {

	@Autowired
	private EntrepriseRepository entrepriseRepository;

	@Override
	public void sauvegarder(Entreprise nouvelleEntreprise) {
		entrepriseRepository.save(nouvelleEntreprise);
	}


	@Override
	public void mettreAJour(Entreprise entreprise) {
		entrepriseRepository.save(entreprise);
	}


	@Override
	public void supprimer(Entreprise entreprise) {
		entrepriseRepository.delete(entreprise);
	}


	@Override
	public List<Entreprise> lister() {
		return entrepriseRepository.findAll();
	}

}
