/**
 * 
 */
package dev.paie.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;

/**
 * @author GOBERT Guillaume
 *
 */
@Service
public class CotisationServiceJpa implements CotisationServiceInterface {
	
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
	public List<Cotisation> lister() {
		TypedQuery<Cotisation> query = em.createQuery("SELECT c FROM Cotisation c", Cotisation.class);
		List<Cotisation> lesCotisations = query.getResultList();
		return lesCotisations;
	}

	@Override
	@Transactional
	public void supprimer(Cotisation supprimerCotisation) {
		Query delete = em.createQuery("DELETE FROM Cotisation c WHERE c.code = ?");	
		delete.setParameter(1, supprimerCotisation.getCode());
		delete.executeUpdate();
	}
}
