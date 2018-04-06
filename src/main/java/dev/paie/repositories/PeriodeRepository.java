/**
 * 
 */
package dev.paie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entites.Periode;

/**
 * @author kevin
 *
 */
public interface PeriodeRepository extends JpaRepository<Periode, Integer> {
}
