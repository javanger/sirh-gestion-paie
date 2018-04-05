/**
 * 
 */
package dev.paie.service;

import java.util.List;

import dev.paie.entite.Entreprise;

/**
 * @author Emmanuel
 *
 */
@FunctionalInterface
public interface IEntrepriseService {

	List<Entreprise> lister();
	
}
