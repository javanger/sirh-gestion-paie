package dev.paie.service;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceMySQLConfig;
import dev.paie.config.JpaConfig;
import dev.paie.entite.Cotisation;

//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { JpaConfig.class, CotisationServiceJpa.class,  DataSourceMySQLConfig.class })
// Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
// test
@RunWith(SpringRunner.class)

// TODO compléter la configuration
public class CotisationServiceJpaTest {
	@Autowired
	private CotisationService cotisationService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// TODO sauvegarder une nouvelle cotisation
		
		Cotisation nouvelleCotisation = new Cotisation();
		
		nouvelleCotisation.setCode("SAL");
		nouvelleCotisation.setLibelle("salaire");
		nouvelleCotisation.setTauxPatronal(new BigDecimal("0.6"));
		nouvelleCotisation.setTauxSalarial(new BigDecimal("0.7"));
		
		cotisationService.sauvegarder(nouvelleCotisation);
		
		
		// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation
		// via la méthode lister
		// TODO modifier une cotisation
		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode lister
	}
}
