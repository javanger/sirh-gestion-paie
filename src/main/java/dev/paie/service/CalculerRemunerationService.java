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
	
	/** calcul un bulletin de salaire 
	 * @param bulletin
	 * @return un bulletin de salaire
	 */
	ResultatCalculRemuneration calculer(BulletinSalaire bulletin); 
	
}
