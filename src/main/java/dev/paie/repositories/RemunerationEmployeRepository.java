/**
 * 
 */
package dev.paie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entites.RemunerationEmploye;

/**
 * @author kevin
 *
 */
public interface RemunerationEmployeRepository extends JpaRepository<RemunerationEmploye, Integer> {
}
