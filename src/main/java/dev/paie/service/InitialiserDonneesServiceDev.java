package dev.paie.service;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.Utilisateur;

@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService{
	
	@PersistenceContext
	private EntityManager em;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void initialiser() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("configWeb.xml");
		
		Stream.of(Cotisation.class, Entreprise.class, Grade.class, ProfilRemuneration.class)
		.flatMap(classe -> context.getBeansOfType(classe).values().stream())
		.forEach(em::persist);
		
		Stream.of(Utilisateur.class)
		.flatMap(classe -> context.getBeansOfType(classe).values().stream())
		.forEach(utilisateur -> {
			utilisateur.setMotDePasse(this.passwordEncoder.encode(utilisateur.getMotDePasse()));
					em.persist(utilisateur);
		});
	
		context.close();
		
		Stream.of(Month.values())
		.map(mois -> {
			Periode periode = new Periode();
			periode.setDateDebut(LocalDate.of( LocalDate.now().getYear(), mois, 1));
			periode.setDateFin(periode.getDateDebut().with(TemporalAdjusters.lastDayOfMonth()));
			periode.setDebutFin();
			return periode;
		})
		.forEach(em::persist);
		
	}

}
