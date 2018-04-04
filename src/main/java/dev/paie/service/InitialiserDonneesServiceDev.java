/**
 * 
 */
package dev.paie.service;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;

/**
 * @author Axel B.
 *
 */
@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	private ClassPathXmlApplicationContext context;
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void initialiser() {

		context = new ClassPathXmlApplicationContext("cotisations-imposables.xml", "entreprises.xml",
				"cotisations-non-imposables.xml", "grades.xml", "profils-remuneration.xml");

		Map<String, Cotisation> cotisations = context.getBeansOfType(Cotisation.class);
		cotisations.forEach((k, v) -> {
			em.persist(v);
		});

		Map<String, Entreprise> entreprises = context.getBeansOfType(Entreprise.class);
		entreprises.forEach((k, v) -> {
			em.persist(v);
		});

		Map<String, Grade> grades = context.getBeansOfType(Grade.class);
		grades.forEach((k, v) -> {
			em.persist(v);
		});

		Map<String, ProfilRemuneration> profilsRemuneration = context.getBeansOfType(ProfilRemuneration.class);
		profilsRemuneration.forEach((k, v) -> {
			em.persist(v);
		});

	}

}
