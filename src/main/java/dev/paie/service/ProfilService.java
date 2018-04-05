/**
 * 
 */
package dev.paie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.paie.entite.ProfilRemuneration;

/**
 * @author Alexis Darcy
 *
 */
@Service
public interface ProfilService {
	
	void sauvegarder(ProfilRemuneration nouveauProfilRemuneration);

	void mettreAJour(ProfilRemuneration profilRemuneration);

	void supprimer(ProfilRemuneration profilRemuneration);
	
	List<ProfilRemuneration> lister();
	
}