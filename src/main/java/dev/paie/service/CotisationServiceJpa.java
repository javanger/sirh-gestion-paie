/**
 * 
 */
package dev.paie.service;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;

/**
 * @author Alexis Darcy
 *
 */
@Service
public class CotisationServiceJpa implements CotisationService {

	@PersistenceContext private EntityManager em;
	
	@Override
	@Transactional
	public void sauvegarder(Cotisation nouvelleCotisation) {
		em.persist(nouvelleCotisation);
	}

	@Override
	@Transactional
	public void mettreAJour(Cotisation cotisation) {
		em.merge(cotisation);
	}
	
	@Override
	@Transactional
	public void supprimer(Cotisation cotisation) {
		Query delete = em.createQuery("Delete From Cotisation c Where c.code = ?");
		delete.setParameter(1, cotisation.getCode());
		delete.executeUpdate();
	}

	
	@Override
	public List<Cotisation> lister() {
		
		TypedQuery<Cotisation> cotisationQuery = em.createQuery("select c from Cotisation c", Cotisation.class);
		List<Cotisation> listCotisation = cotisationQuery.getResultList();
		
		return listCotisation;
		
	}


}
