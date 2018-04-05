/**
 * 
 */
package dev.paie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.paie.entite.Entreprise;
import dev.paie.repository.EntrepriseRepository;

/**
 * @author Axel B.
 *
 */
@Component
public class EntrepriseService {

	@Autowired
	EntrepriseRepository entrepriseRepository;

	public List<Entreprise> list() {
		return entrepriseRepository.findAll();
	}

	public void save(Entreprise entreprise) {
		entrepriseRepository.save(entreprise);
	}
}
