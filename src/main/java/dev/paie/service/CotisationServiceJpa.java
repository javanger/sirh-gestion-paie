/**
 * 
 */
package dev.paie.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import dev.paie.config.JpaConfig;
import dev.paie.entite.Cotisation;

/**
 * @author Kevin M.
 *
 */
@Service
public class CotisationServiceJpa implements CotisationService {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Constructor
	 * 
	 */
	public CotisationServiceJpa() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dev.paie.service.CotisationService#sauvegarder(dev.paie.entite.
	 * Cotisation)
	 */
	@Override
	public void sauvegarder(Cotisation nouvelleCotisation) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dev.paie.service.CotisationService#mettreAjour(dev.paie.entite.
	 * Cotisation)
	 */
	@Override
	public void mettreAjour(Cotisation cotisation) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dev.paie.service.CotisationService#lister()
	 */
	@Override
	public List<Cotisation> lister() {
		// TODO Auto-generated method stub
		return null;
	}

}
