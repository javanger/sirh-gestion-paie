package dev.paie.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceH2Config;
import dev.paie.config.JpaConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Cotisation;
import dev.paie.entite.Grade;

//TODO compléter la configuration
//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { DataSourceH2Config.class, JpaConfig.class, ServicesConfig.class })
// Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
// test
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {

	@Autowired
	private CotisationService cotisationService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// TODO sauvegarder une nouvelle cotisation
		// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation
		// via la méthode lister

		Cotisation cotisation = new Cotisation();

		cotisation.setCode("beta");
		cotisation.setLibelle("dicotomie");
		cotisation.setTauxPatronal(new BigDecimal("145.15"));
		cotisation.setTauxSalarial(new BigDecimal("4569.25"));
		cotisationService.sauvegarder(cotisation);

		assertTrue("list vide", cotisationService.lister().isEmpty() == false);

		// TODO modifier un grade
		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode lister

		Cotisation newCotisation = new Cotisation();
		newCotisation.setCode("beta");
		newCotisation.setLibelle("nouveau");
		newCotisation.setTauxPatronal(new BigDecimal("12547.15"));
		newCotisation.setTauxSalarial(new BigDecimal("74123.25"));

		cotisationService.mettreAJour(newCotisation);

		Cotisation cotisationModifie = cotisationService.lister().stream().filter(p -> p.getCode().equals("beta")).findAny().get();
		assertTrue("12547.15", new BigDecimal("12547.15").compareTo(cotisationModifie.getTauxPatronal())==0);
		assertTrue("74123.25", new BigDecimal("74123.25").compareTo(cotisationModifie.getTauxSalarial()) == 0);
		assertEquals("nouveau", cotisationModifie.getLibelle());
	}

}
