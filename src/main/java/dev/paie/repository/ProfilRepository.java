/**
 * 
 */
package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.ProfilRemuneration;

/**
 * @author GOBERT Guillaume
 *
 */
public interface ProfilRepository extends JpaRepository<ProfilRemuneration, Integer> {

}
