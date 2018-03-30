/**
 * 
 */
package dev.paie.service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;

/**
 * @author Alexis Darcy
 *
 */
public interface CalculerRemunerationService {   
	
	ResultatCalculRemuneration calculer(BulletinSalaire bulletin); 
	
}
