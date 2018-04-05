/**
 * 
 */
package dev.paie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entites.Grade;

/**
 * @author kevin
 *
 */
public interface GradeRepository extends JpaRepository<Grade, Integer> {
}
