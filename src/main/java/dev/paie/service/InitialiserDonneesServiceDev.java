/**
 * 
 */
package dev.paie.service;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.jpa.event.internal.jpa.ListenerFactoryStandardImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;

/**
 * @author Alexis Darcy
 *
 */
@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService{

	@PersistenceContext private EntityManager em;
	
	
	@Override
	@Transactional
	public void initialiser() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("cotisations-imposables.xml",
				"cotisations-non-imposables.xml","entreprises.xml","grades.xml",
				"profils-remuneration.xml");
		
		Stream.of(Cotisation.class, Entreprise.class, Grade.class, ProfilRemuneration.class)
			.flatMap(classe -> context.getBeansOfType(classe).values().stream())
			.forEach(em::persist);
		
		
		Stream.of(Month.values())
			.map(mois -> {
				Periode periode = new Periode();
				periode.setDateDebut(LocalDate.of( LocalDate.now().getYear(), mois, 1));
				periode.setDateFin(periode.getDateDebut().with(TemporalAdjusters.lastDayOfMonth()));
				return periode;
			})
			.forEach(em::persist);
		
		/*
		Map<String, Cotisation> cotisations = context.getBeansOfType(Cotisation.class);
		
		cotisations.forEach((x, y) -> {
			em.persist(y);
		});
		
		Map<String, Entreprise> entreprises = context.getBeansOfType(Entreprise.class);
		
		entreprises.forEach((x, y) -> {
			em.persist(y);
		});
		
		Map<String, Grade> grades = context.getBeansOfType(Grade.class);
		
		grades.forEach((x, y) -> {
			em.persist(y);
		});
		
		Map<String, ProfilRemuneration> profilRemunerations= context.getBeansOfType(ProfilRemuneration.class);
		
		profilRemunerations.forEach((x, y) -> {
			em.persist(y);
		});
		
		List<Periode> periodes = new ArrayList<Periode>();
		LocalDate date = LocalDate.now().with(TemporalAdjusters.firstDayOfYear());
		for(int i = 0 ; i < 12 ; i++){
			Periode periode = new Periode();
			periode.setDateDebut(date);
			date = date.with(TemporalAdjusters.lastDayOfMonth());
			periode.setDateFin(date);
			periodes.add(periode);
			date = date.with(TemporalAdjusters.firstDayOfNextMonth());
		}
		*/
		
	}
}
