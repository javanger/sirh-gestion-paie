package dev.paie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.paie.entite.BulletinSalaire;

public interface BulletinSalaireRepository extends JpaRepository<BulletinSalaire, Integer> {
	@EntityGraph(type = EntityGraphType.LOAD, attributePaths = {
			"remunerationEmploye.profilRemuneration.cotisationsNonImposables",
			"remunerationEmploye.profilRemuneration.cotisationsImposables" })
	@Query("select b from BulletinSalaire b")
	List<BulletinSalaire> findAllWithCotisations();

}
