/**
 * 
 */
package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.ProfilRemuneration;

/**
 * @author Alexis Darcy
 *
 */
public interface ProfilRepository extends JpaRepository<ProfilRemuneration, Integer> {
}
