/**
 * 
 */
package dev.paie.services;

import dev.paie.entites.BulletinSalaire;
import dev.paie.entites.ResultatCalculRemuneration;

/**
 * @author Kevin M.
 *
 */
@FunctionalInterface
interface CalculerRemunerationService {
	ResultatCalculRemuneration calculer(BulletinSalaire bulletin);
}
