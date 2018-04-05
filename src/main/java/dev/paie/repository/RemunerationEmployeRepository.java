/**
 * 
 */
package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.RemunerationEmploye;

/**
 * @author Axel B.
 *
 */
public interface RemunerationEmployeRepository extends JpaRepository<RemunerationEmploye, Integer> {

}
