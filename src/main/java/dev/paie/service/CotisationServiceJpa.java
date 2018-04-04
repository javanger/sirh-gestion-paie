package dev.paie.service;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;


@Service
public class CotisationServiceJpa implements CotisationService {

	@PersistenceContext
	private EntityManager em;

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
	public List<Cotisation> lister() {

		TypedQuery<Cotisation> query2 = em.createQuery("select c from Cotisation c", Cotisation.class);
		List<Cotisation> cotis = query2.getResultList();
		return cotis;
	}

	public Cotisation findCotisationByCode(String code) {
		Cotisation cotisationFind = null;
		for (Cotisation c : this.lister()) {
			if (c.getCode().equals(code))
				cotisationFind = c;
		}
		return cotisationFind;
	}

	@Override
	@Transactional
	public void supprimer(Cotisation supprimerCotisation) {
		Query delete = em.createQuery("DELETE FROM Cotisation c WHERE c.code = ?");
		delete.setParameter(1, supprimerCotisation.getCode());
		delete.executeUpdate();
	}
}
