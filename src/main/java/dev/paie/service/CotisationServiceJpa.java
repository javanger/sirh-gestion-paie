package dev.paie.service;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
	public List<Cotisation> lister() {
		List<Cotisation> listCotisation;

		TypedQuery<Cotisation> query = em.createQuery("SELECT c FROM Cotisation c", Cotisation.class);
		listCotisation = query.getResultList();

		return listCotisation;
	}

	@Override
	public Cotisation findCotisationByCode(String code) {
		Cotisation grade = null;

		for (Cotisation g : this.lister()) {
			if (g.getCode().equals(code))
				grade = g;
		}

		return grade;
	}
}
