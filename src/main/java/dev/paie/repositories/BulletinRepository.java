/**
 * 
 */
package dev.paie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entites.BulletinSalaire;

/**
 * @author kevin
 *
 */
public interface BulletinRepository extends JpaRepository<BulletinSalaire, Integer> {
}
