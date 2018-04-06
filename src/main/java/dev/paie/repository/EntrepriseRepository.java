/**
 * 
 */
package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.Entreprise;

/**
 * @author Axel B.
 *
 */
public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {

}
