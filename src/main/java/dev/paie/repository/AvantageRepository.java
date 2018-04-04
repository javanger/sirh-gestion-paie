/**
 * 
 */
package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.paie.entite.Avantage;

/**
 * @author GOBERT Guillaume
 *
 */
public interface AvantageRepository extends JpaRepository<Avantage, Integer>{

	Avantage findByCode(String code);
}
