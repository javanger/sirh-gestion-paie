/**
 * 
 */
package dev.paie.services;

import dev.paie.entites.BulletinSalaire;
import dev.paie.services.model.ResultatCalculRemunerationServiceModel;

/**
 * @author Kevin M.
 *
 */
@FunctionalInterface
public interface CalculerRemunerationService {
	ResultatCalculRemunerationServiceModel calculer(BulletinSalaire bulletin);
}
