/**
 * 
 */
package dev.paie.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import dev.paie.entite.Entreprise;

/**
 * @author Emmanuel
 *
 */
@Service
public class EntrepriseService implements IEntrepriseService {
	
	@PersistenceContext
	private EntityManager em;

	/* (non-Javadoc)
	 * @see dev.paie.service.IEntrepriseService#lister()
	 */
	@Override
	public List<Entreprise> lister() {
		
		TypedQuery<Entreprise> query = em.createQuery("SELECT e FROM Entreprise e", Entreprise.class);
		
		return query.getResultList();
	}

}
