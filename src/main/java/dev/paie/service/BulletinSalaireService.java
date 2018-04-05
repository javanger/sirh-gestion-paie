/**
 * 
 */
package dev.paie.service;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.repository.BulletinSalaireRepository;

/**
 * @author GOBERT Guillaume
 *
 */
@Component
public class BulletinSalaireService {

	@Autowired
	BulletinSalaireRepository bulletinRepository;
	@Autowired
	CalculerRemunerationServiceSimple calculRemunerationService;

	public List<BulletinSalaire> list() {
		return bulletinRepository.findAll();
	}

	public void save(BulletinSalaire bulletin) {
		bulletin.setCreation(ZonedDateTime.now());
		bulletinRepository.save(bulletin);
	}

	@Transactional
	public Map<BulletinSalaire, ResultatCalculRemuneration> calcul() {
		Map<BulletinSalaire, ResultatCalculRemuneration> mapCalcul = new HashMap<>();
		bulletinRepository.findAll().forEach(b -> {
			mapCalcul.put(b, calculRemunerationService.calculer(b));
		});
		return mapCalcul;
	}
}
