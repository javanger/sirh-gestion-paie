/**
 * 
 */
package dev.paie.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entites.Cotisation;

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

	@Override
	public void supprimer(Cotisation cotisation) {
		em.remove(cotisation);
	}

	@Override
	public Cotisation trouverParId(Integer id) {
		TypedQuery<Cotisation> query = em.createQuery("from Cotisation c WHERE c.id = ?", Cotisation.class);
		List<Cotisation> list = query.setParameter(1, id).getResultList();
		return list.isEmpty() ? null : list.get(0);
	}

}
