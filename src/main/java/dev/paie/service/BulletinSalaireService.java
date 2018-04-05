/**
 * 
 */
package dev.paie.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;

/**
 * @author Alexis Darcy
 *
 */
@Service
public interface BulletinSalaireService {
	
	void sauvegarder(BulletinSalaire nouveauBulletinSalaire);

	void mettreAJour(BulletinSalaire bulletinSalaire);

	void supprimer(BulletinSalaire bulletinSalaire);
	
	List<BulletinSalaire> lister();
	
	Map<BulletinSalaire, ResultatCalculRemuneration> calcul();

}