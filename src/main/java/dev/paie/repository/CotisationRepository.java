/**
 * 
 */
package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.Cotisation;

/**
 * @author GOBERT Guillaume
 *
 */
public interface CotisationRepository extends JpaRepository<Cotisation, Integer> {

}
