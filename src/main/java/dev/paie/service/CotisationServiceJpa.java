/**
 * 
 */
package dev.paie.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;

/**
 * @author Axel B.
 *
 */
@Service
public class CotisationServiceJpa implements CotisationService{

	@PersistenceContext 
	private EntityManager em;
	
	
	@Override
	@Transactional
	public void sauvegarder(Cotisation cot) {
		em.persist(cot);
		
	}

	
	@Override
	@Transactional
	public void mettreAJour(Cotisation cot) {
		em.merge(cot);
		
	}
	
	

	@Override
	@Transactional
	public void supprimer(Cotisation cotisation){
		Query delete = em.createQuery("Delete From Cotisation c Where c.code = ?");
		delete.setParameter(1, cotisation.getCode());
		delete.executeUpdate();
				
		
	}

	
	@Override
	public List<Cotisation> lister() {
		
		List<Cotisation> listCotisation = new ArrayList<Cotisation>();

		TypedQuery<Cotisation> query = em.createQuery("SELECT c FROM Cotisation c", Cotisation.class);
		listCotisation = query.getResultList();

		return listCotisation;
		
	}

}
