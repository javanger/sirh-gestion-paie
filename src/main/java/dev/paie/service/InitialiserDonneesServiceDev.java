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

	@PersistenceContext
	private EntityManager em;

	@Transactional
	@Override
	public void initialiser() {


		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("donnees.xml");
		Map<String, Cotisation> cotis = ctx.getBeansOfType(Cotisation.class);


		cotis.forEach((cle, valeur) -> {
			em.persist(valeur);
		});

		Map<String, Entreprise> entreprises = ctx.getBeansOfType(Entreprise.class);
		entreprises.forEach((cle, valeur) -> {
			em.persist(valeur);
		});

		Map<String, Grade> grades = ctx.getBeansOfType(Grade.class);
		grades.forEach((cle, valeur) -> {
			em.persist(valeur);
		});

		Map<String, ProfilRemuneration> remuEmpl = ctx.getBeansOfType(ProfilRemuneration.class);
		remuEmpl.forEach((cle, valeur) -> {
			em.persist(valeur);
		});

		ctx.close();
		
		Stream.of(Month.values()).map(mois -> {
					Periode periode = new Periode();
					periode.setDateDebut(LocalDate.of(LocalDate.now().getYear(), mois, 1));
					periode.setDateFin(periode.getDateDebut().with(TemporalAdjusters.lastDayOfMonth()));
					return periode;
					}).forEach(em::persist);
			
				}





	}


