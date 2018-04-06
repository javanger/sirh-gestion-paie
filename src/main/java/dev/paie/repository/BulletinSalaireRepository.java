/**
 * 
 */
package dev.paie.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.BulletinSalaire;

/**
 * @author Alexis Darcy
 *
 */
public interface BulletinSalaireRepository extends JpaRepository<BulletinSalaire, Integer> {
	@EntityGraph(type = EntityGraphType.LOAD, attributePaths = {
            "remunerationEmploye.profilRemuneration.cotisationsNonImposables",
            "remunerationEmploye.profilRemuneration.cotisationsImposables" })
	BulletinSalaire findById(Integer id);
}
