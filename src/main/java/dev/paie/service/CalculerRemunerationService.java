/**
 * 
 */
package dev.paie.service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;

/**
 * @author Axel B.
 *
 */
public interface CalculerRemunerationService {

	ResultatCalculRemuneration calculer(BulletinSalaire bulletin);
}
