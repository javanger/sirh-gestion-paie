/**
 * 
 */
package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.Avantage;
import dev.paie.entite.Grade;

/**
 * @author Alexis Darcy
 *
 */
public interface GradeRepository extends JpaRepository<Grade, Integer> { 
	Avantage findByCode(String code);
}
