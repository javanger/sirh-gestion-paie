package dev.paie.service;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
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

/**
 * @author Emmanuel
 *
 */
@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	@PersistenceContext
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see dev.paie.service.InitialiserDonneesService#initialiser()
	 */
	@Override
	@Transactional
	public void initialiser() {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("configWeb.xml");

		Stream.of(Cotisation.class, Entreprise.class, Grade.class, ProfilRemuneration.class)
				.flatMap(classe -> context.getBeansOfType(classe).values().stream())
				.forEach(em::persist);

		context.close();

		Stream.of(Month.values()).map(mois -> {
			Periode periode = new Periode();
			periode.setDateDebut(LocalDate.of(LocalDate.now().getYear(), mois, 1));
			periode.setDateFin(periode.getDateDebut().with(TemporalAdjusters.lastDayOfMonth()));
			return periode;
		}).forEach(em::persist);

	}

}
