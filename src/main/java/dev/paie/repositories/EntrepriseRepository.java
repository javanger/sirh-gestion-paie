/**
 * 
 */
package dev.paie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entites.Entreprise;

/**
 * @author kevin
 *
 */
public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {
}
