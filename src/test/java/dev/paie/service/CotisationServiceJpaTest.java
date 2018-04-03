package dev.paie.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceH2;
import dev.paie.config.JpaConfig;
import dev.paie.entite.Cotisation;

//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { CotisationServiceJpa.class, JpaConfig.class, DataSourceH2.class })
// Configuration JUnit pour que Spring prenne la main sur le cycle de vie du test
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {

	@Autowired
	private CotisationService cotisationService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// TODO sauvegarder une nouvelle cotisation
		// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation
		// via laméthode lister
		Cotisation cotisation = new Cotisation();
		cotisation.setCode("1548484");
		cotisation.setLibelle("coucou");
		cotisation.setTauxPatronal(new BigDecimal("2665.3"));
		cotisation.setTauxSalarial(new BigDecimal("36.30"));
		
		cotisationService.sauvegarder(cotisation);
		
		assertEquals("1548484", cotisationService.findCotisationByCode("1548484").getCode());
		assertEquals("coucou", cotisationService.findCotisationByCode("1548484").getLibelle());
		assert new BigDecimal("2665.3").compareTo(cotisationService.findCotisationByCode("1548484").getTauxPatronal()) == 0;
		assert new BigDecimal("36.30").compareTo(cotisationService.findCotisationByCode("1548484").getTauxSalarial()) == 0;
		
		

		// TODO modifier une cotisation
		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode lister
		
		Cotisation cotisationUpdate = new Cotisation();
		cotisationUpdate.setCode("1548484");
		cotisationUpdate.setLibelle("modifie");
		cotisationUpdate.setTauxPatronal(new BigDecimal("26492.2"));
		cotisationUpdate.setTauxSalarial(new BigDecimal("56.30"));
		
		cotisationService.mettreAJour(cotisationUpdate);
		
		assertEquals("modifie", cotisationService.findCotisationByCode("1548484").getLibelle());
		assert new BigDecimal("26492.2").compareTo(cotisationService.findCotisationByCode("1548484").getTauxPatronal()) == 0;
		assert new BigDecimal("56.30").compareTo(cotisationService.findCotisationByCode("1548484").getTauxSalarial()) == 0;
	}
}
