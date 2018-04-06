/**
 * 
 */
package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.Entreprise;

/**
 * @author Emmanuel
 *
 */
public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {
	
}
