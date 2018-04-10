/**
 * 
 */
package dev.paie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.ProfilRepository;

/**
 * @author Alexis Darcy
 *
 */
@Service
public class ProfilServiceDataJpa implements ProfilService {

	@Autowired
	private ProfilRepository profilRepository;

	@Override
	public void sauvegarder(ProfilRemuneration nouveauProfilRemuneration) {
		profilRepository.save(nouveauProfilRemuneration);
	}


	@Override
	public void mettreAJour(ProfilRemuneration profilRemuneration) {
		profilRepository.save(profilRemuneration);
	}

	@Override
	public void supprimer(ProfilRemuneration profilRemuneration) {
		profilRepository.delete(profilRemuneration);
	}

	@Override
	public List<ProfilRemuneration> lister() {
		return profilRepository.findAll();
	}

}
