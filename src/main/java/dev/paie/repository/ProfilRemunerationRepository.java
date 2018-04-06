/**
 * 
 */
package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.ProfilRemuneration;

/**
 * @author Emmanuel
 *
 */
public interface ProfilRemunerationRepository extends JpaRepository<ProfilRemuneration, Integer> {
	
}
