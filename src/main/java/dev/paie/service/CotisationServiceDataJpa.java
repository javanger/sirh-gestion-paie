/**
 * 
 */
package dev.paie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dev.paie.entite.Cotisation;
import dev.paie.repository.CotisationRepository;

/**
 * @author Alexis Darcy
 *
 */
public class CotisationServiceDataJpa implements CotisationService {

	@Autowired
	private CotisationRepository cotisationRepository;

	@Override
	public void sauvegarder(Cotisation nouvelleCotisation) {
		cotisationRepository.save(nouvelleCotisation);
	}


	@Override
	public void mettreAJour(Cotisation cotisation) {
		cotisationRepository.save(cotisation);
	}


	@Override
	public void supprimer(Cotisation cotisation) {
		cotisationRepository.delete(cotisation);
	}

	@Override
	public List<Cotisation> lister() {
		return cotisationRepository.findAll();
	}

}
