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
import dev.paie.util.PaieUtils;

/**
 * @author Axel B.
 *
 */
@Component
public class BulletinSalaireService {

	@Autowired
	BulletinSalaireRepository bulletinSalaireRepository;

	@Autowired
	CalculerRemunerationService calculRemunerationService;

	@Autowired
	PaieUtils paieUtils;

	public List<BulletinSalaire> list() {
		return bulletinSalaireRepository.findAll();
	}

	public void save(BulletinSalaire bulletin) {
		bulletin.setCreation(ZonedDateTime.now());
		bulletinSalaireRepository.save(bulletin);
	}

	@Transactional
	public Map<BulletinSalaire, ResultatCalculRemuneration> calcul() {
		Map<BulletinSalaire, ResultatCalculRemuneration> mapCalcul = new HashMap<>();
		bulletinSalaireRepository.findAll().forEach(b -> {
			mapCalcul.put(b, calculRemunerationService.calculer(b));
		});
		return mapCalcul;
	}
}
