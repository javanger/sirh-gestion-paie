package dev.paie.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;

/**
 * @author Emmanuel
 *
 */
@Service
public class CotisationService implements ICotisationService {
	
	@PersistenceContext
	private EntityManager em;

	/* (non-Javadoc)
	 * @see dev.paie.service.CotisationService#sauvegarder(dev.paie.entite.Cotisation)
	 */
	@Override
	@Transactional
	public void sauvegarder(Cotisation nouvelleCotisation) {
		em.persist(nouvelleCotisation);
	}

	/* (non-Javadoc)
	 * @see dev.paie.service.CotisationService#mettreAJour(dev.paie.entite.Cotisation)
	 */
	@Override
	@Transactional
	public void mettreAJour(Cotisation cotisation) {
		em.merge(cotisation);		
	}

	/* (non-Javadoc)
	 * @see dev.paie.service.CotisationService#lister()
	 */
	@Override
	@Transactional
	public List<Cotisation> lister() {
		
		TypedQuery<Cotisation> query = em.createQuery("SELECT c FROM Cotisation c", Cotisation.class);
		
		return query.getResultList();
	}

}