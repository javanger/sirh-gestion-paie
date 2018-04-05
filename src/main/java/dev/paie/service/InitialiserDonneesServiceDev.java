package dev.paie.service;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.Map;
import java.util.stream.Stream;

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

	private ClassPathXmlApplicationContext context;
	@PersistenceContext
	private EntityManager em;


	@Override
	@Transactional
	public void initialiser() {
		context = new ClassPathXmlApplicationContext("jdd-config.xml");

		Map<String, Cotisation> cotis = context.getBeansOfType(Cotisation.class);
		cotis.forEach((id, obj) -> {
			em.persist(obj);
		});

		Map<String, Grade> grad = context.getBeansOfType(Grade.class);
		grad.forEach((id, obj) -> {
			em.persist(obj);
		});

		Map<String, Entreprise> entrep = context.getBeansOfType(Entreprise.class);
		entrep.forEach((id, obj) -> {
			em.persist(obj);
		});

		Map<String, ProfilRemuneration> profilRem = context.getBeansOfType(ProfilRemuneration.class);
		profilRem.forEach((id, obj) -> {
			em.persist(obj);
		});

		context.close();

		Stream.of(Month.values()).map(mois -> {
			Periode periode = new Periode();
			periode.setDateDebut(LocalDate.of(LocalDate.now().getYear(), mois, 1));
			periode.setDateFin(periode.getDateDebut().with(TemporalAdjusters.lastDayOfMonth()));
			return periode;
		}).forEach(em::persist);

	}

}
