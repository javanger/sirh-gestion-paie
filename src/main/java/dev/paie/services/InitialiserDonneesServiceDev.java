/**
 * 
 */
package dev.paie.services;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entites.Cotisation;
import dev.paie.entites.Entreprise;
import dev.paie.entites.Grade;
import dev.paie.entites.ProfilRemuneration;

/**
 * @author Kevin M.
 *
 */
@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	@PersistenceContext
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * @see dev.paie.services.InitialiserDonneesService#initialiser()
	 */
	@Override
	@Transactional
	public void initialiser() {

		// extraire les grades du fichier xml
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("grades.xml", "entreprises.xml",
				"cotisations-imposables.xml", "cotisations-non-imposables.xml", "profils-remuneration.xml");
		Map<String, Cotisation> cotisations = context.getBeansOfType(Cotisation.class);
		Map<String, Entreprise> entreprises = context.getBeansOfType(Entreprise.class);
		Map<String, Grade> grades = context.getBeansOfType(Grade.class);
		Map<String, ProfilRemuneration> profils = context.getBeansOfType(ProfilRemuneration.class);

		cotisations.forEach((cle, valeur) -> {
			if (valeur != null)
				em.persist(valeur);
		});

		entreprises.forEach((cle, valeur) -> {
			if (valeur != null)
				em.persist(valeur);
		});

		grades.forEach((cle, valeur) -> {
			if (valeur != null)
				em.persist(valeur);
		});

		profils.forEach((cle, valeur) -> {
			if (valeur != null)
				em.persist(valeur);
		});

	}
}
