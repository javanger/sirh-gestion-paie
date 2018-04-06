/**
 * 
 */
package dev.paie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.ProfilRepository;

/**
 * @author Axel B.
 *
 */
@Component
public class ProfilService {

	@Autowired
	ProfilRepository profilRepository;

	public List<ProfilRemuneration> list() {
		return profilRepository.findAll();
	}

	public void save(ProfilRemuneration profil) {
		profilRepository.save(profil);
	}
}
