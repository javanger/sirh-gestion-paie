/**
 * 
 */
package dev.paie.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;

/**
 * @author Kevin M.
 *
 */
@Service
public class CotisationServiceJpa implements CotisationService {

	@PersistenceContext
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see dev.paie.service.CotisationService#sauvegarder(dev.paie.entite.
	 * Cotisation)
	 */
	@Override
	@Transactional
	public void sauvegarder(Cotisation nouvelleCotisation) {
		em.persist(nouvelleCotisation);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dev.paie.service.CotisationService#mettreAjour(dev.paie.entite.
	 * Cotisation)
	 */
	@Override
	@Transactional
	public void mettreAjour(Cotisation cotisation) {
		em.merge(cotisation);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dev.paie.service.CotisationService#lister()
	 */
	@Override
	public List<Cotisation> lister() {
		return em.createQuery("from Cotisation", Cotisation.class).getResultList();
	}

}
