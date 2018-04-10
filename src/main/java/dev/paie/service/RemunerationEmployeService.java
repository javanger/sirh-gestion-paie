/**
 * 
 */
package dev.paie.service;

import java.util.List;

import dev.paie.entite.RemunerationEmploye;

/**
 * @author Alexis Darcy
 *
 */
public interface RemunerationEmployeService {

	void sauvegarder(RemunerationEmploye nouveauRemunerationEmploye);

	void mettreAJour(RemunerationEmploye remunerationEmploye);

	void supprimer(RemunerationEmploye remunerationEmploye);

	List<RemunerationEmploye> lister();

}
