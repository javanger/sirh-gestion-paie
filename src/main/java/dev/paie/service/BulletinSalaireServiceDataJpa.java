/**
 * 
 */
package dev.paie.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.repository.BulletinSalaireRepository;

/**
 * @author Alexis Darcy
 *
 */
@Service
public class BulletinSalaireServiceDataJpa implements BulletinSalaireService {

	@Autowired
	private BulletinSalaireRepository bulletinSalaireRepository;

	@Autowired
	private CalculerRemunerationService calculerRemunerationService;

	@Override
	public void sauvegarder(BulletinSalaire nouveauBulletinSalaire) {
		bulletinSalaireRepository.save(nouveauBulletinSalaire);
	}

	@Override
	public void mettreAJour(BulletinSalaire bulletinSalaire) {
		bulletinSalaireRepository.save(bulletinSalaire);
	}

	@Override
	public void supprimer(BulletinSalaire bulletinSalaire) {
		bulletinSalaireRepository.delete(bulletinSalaire);
	}

	@Override
	public List<BulletinSalaire> lister() {
		return bulletinSalaireRepository.findAll();
	}

	@Override
	public BulletinSalaire recuperer(Integer bulletinSalaire) {
		return bulletinSalaireRepository.findById(bulletinSalaire);
	}

	@Override
	@Transactional
	public Map<BulletinSalaire, ResultatCalculRemuneration> calcul() {
		Map<BulletinSalaire, ResultatCalculRemuneration> mapCalcul = new TreeMap<BulletinSalaire, ResultatCalculRemuneration>(
				Comparator.comparing(BulletinSalaire::getDateCreation));
		bulletinSalaireRepository.findAll().forEach(b -> {
			mapCalcul.put(b, calculerRemunerationService.calculer(b));
		});
		return mapCalcul;
	}

	@Override
	@Transactional
	public ResultatCalculRemuneration calcul(Integer bulletinSalaire) {
		return calculerRemunerationService.calculer(recuperer(bulletinSalaire));
	}
}
