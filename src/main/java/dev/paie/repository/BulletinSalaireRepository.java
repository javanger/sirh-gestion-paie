/**
 * 
 */
package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.BulletinSalaire;

/**
 * @author GOBERT Guillaume
 *
 */
public interface BulletinSalaireRepository extends JpaRepository<BulletinSalaire, Integer> {

}
