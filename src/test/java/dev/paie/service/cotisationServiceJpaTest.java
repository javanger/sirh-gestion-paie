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


@ContextConfiguration(classes = { JpaConfig.class, ServicesConfig.class, DataSourceH2Config.class})

@RunWith(SpringRunner.class)
public class cotisationServiceJpaTest {
	@Autowired
	private CotisationService cotisationService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
	// TODO sauvegarder une nouvelle cotisation
		Cotisation cotisation = new Cotisation();
		cotisation.setCode("def");
		cotisation.setLibelle("defu");
		cotisation.setTauxSalarial(new BigDecimal("13.00"));
		cotisation.setTauxPatronal(new BigDecimal("25.00"));
		
		//assertTrue("liste null", cotisationService.lister() != null);
		//assertTrue("liste vide", cotisationService.lister().isEmpty() == false);
		
		cotisationService.sauvegarder(cotisation);
		Cotisation cotisationcreer = cotisationService.findCotisationByCode("def");
		assertEquals("def", cotisationcreer.getCode());
		assertEquals("defu", cotisationcreer.getLibelle());
		assert new BigDecimal("13.00").compareTo(cotisationcreer.getTauxSalarial()) == 0;
		assert new BigDecimal("25.00").compareTo(cotisationcreer.getTauxPatronal()) == 0;
		
	// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation via la méthode lister
	// TODO modifier une cotisation
		
		cotisationcreer.setCode("sdep");
		cotisationcreer.setLibelle("dif");
		cotisationcreer.setTauxSalarial(new BigDecimal("22.00"));
		cotisationcreer.setTauxPatronal(new BigDecimal("56.00"));
		cotisationService.mettreAJour(cotisationcreer);
		
	// TODO vérifier que les modifications sont bien prises en compte via la méthode lister
		assertEquals("sdep", cotisationcreer.getCode());
		assertEquals("dif", cotisationcreer.getLibelle());
		assert new BigDecimal("22.00").compareTo(cotisationcreer.getTauxSalarial()) == 0;
		assert new BigDecimal("56.00").compareTo(cotisationcreer.getTauxPatronal()) == 0;
	 
		//cotisationService.supprimer(cotisationcreer);
	}
	
}
