/**
 * 
 */
package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.Entreprise;

/**
 * @author GOBERT Guillaume
 *
 */
public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {

}
