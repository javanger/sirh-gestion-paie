package dev.paie.service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;

/**
 * @author Emmanuel
 *
 */
public interface CalculerRemunerationService {
	
	ResultatCalculRemuneration calculer(BulletinSalaire bulletin);
	
}
