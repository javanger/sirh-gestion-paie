package dev.paie.service;

import java.util.List;
import java.util.Map;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;


public interface BulletinSalaireService {

	void sauvegarder(BulletinSalaire newBulletinSalaire);
	void mettreAJour(BulletinSalaire bulletinSalaire);

	void supprimer(BulletinSalaire bulletinSalaire);
	List<BulletinSalaire> lister();

	Map<BulletinSalaire, ResultatCalculRemuneration> calcul();
	
}
