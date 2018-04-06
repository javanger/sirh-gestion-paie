package dev.paie.service;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;

@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	@Override
	public void initialiser() {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("contextConfig.xml");

		Map<String, Cotisation> cotisation = context.getBeansOfType(Cotisation.class);

		cotisation.forEach((x, y) -> {
			em.persist(y);
		});

		Map<String, Entreprise> entreprise = context.getBeansOfType(Entreprise.class);

		entreprise.forEach((x, y) -> {
			em.persist(y);
		});

		Map<String, Grade> grade = context.getBeansOfType(Grade.class);

		grade.forEach((x, y) -> {
			em.persist(y);
		});

		Map<String, ProfilRemuneration> profilRemuneration = context.getBeansOfType(ProfilRemuneration.class);

		profilRemuneration.forEach((x, y) -> {
			em.persist(y);
		});

		List<Periode> periode = new ArrayList<Periode>();
		LocalDate date = LocalDate.now().with(TemporalAdjusters.firstDayOfYear());
		for (int i = 0; i < 12; i++) {
			Periode p = new Periode();
			p.setDateDebut(date);
			date = date.with(TemporalAdjusters.lastDayOfMonth());
			p.setDateFin(date);
			periode.add(p);
			date = date.with(TemporalAdjusters.firstDayOfNextMonth());
		}

		periode.forEach((y) -> {
			em.persist(y);
		});
	}

}
