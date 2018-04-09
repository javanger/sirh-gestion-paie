/**
 * 
 */
package dev.paie.service;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import dev.paie.entite.Utilisateur.ROLES;

/**
 * @author Axel B.
 *
 */
@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	private ClassPathXmlApplicationContext context;
	@PersistenceContext
	private EntityManager em;

	@Autowired
	private PasswordEncoder passwordEncoder;

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

		List<Periode> periodes = new ArrayList<Periode>();
		LocalDate date = LocalDate.now().with(TemporalAdjusters.firstDayOfYear());
		for (int i = 0; i < 12; i++) {
			Periode periode = new Periode();
			periode.setDateDebut(date);
			date = date.with(TemporalAdjusters.lastDayOfMonth());
			periode.setDateFin(date);
			periodes.add(periode);
			date = date.with(TemporalAdjusters.firstDayOfNextMonth());
		}
		periodes.forEach(x -> em.persist(x));

		Utilisateur user = new Utilisateur();

		String passwordHashe = this.passwordEncoder.encode("user");
		user.setEstActif(true);
		user.setNomUtilisateur("user");
		user.setMotDePasse(passwordHashe);
		user.setRole(ROLES.ROLE_UTILISATEUR);

		em.persist(user);

		Utilisateur admin = new Utilisateur();
		passwordHashe = this.passwordEncoder.encode("admin");
		admin.setEstActif(true);
		admin.setNomUtilisateur("admin");
		admin.setMotDePasse(passwordHashe);
		admin.setRole(ROLES.ROLE_ADMINISTRATEUR);

		em.persist(admin);

	}

}
