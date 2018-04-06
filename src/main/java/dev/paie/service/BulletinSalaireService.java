/**
 * 
 */
package dev.paie.service;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.paie.entite.BulletinSalaire;
import dev.paie.repository.BulletinSalaireRepository;

/**
 * @author Axel B.
 *
 */
@Component
public class BulletinSalaireService {

	@Autowired
	BulletinSalaireRepository bulletinSalaireRepository;

	// @Autowired
	// CalculerRemunerationServiceSimple calculRemunerationService;

	public List<BulletinSalaire> list() {
		return bulletinSalaireRepository.findAll();
	}

	public void save(BulletinSalaire bulletin) {
		bulletin.setCreation(ZonedDateTime.now());
		bulletinSalaireRepository.save(bulletin);
	}

}
