package dev.paie.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceH2Config;
import dev.paie.config.DataSourceMySQLConfig;
import dev.paie.config.JpaConfig;
import dev.paie.entite.Cotisation;

//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { JpaConfig.class, CotisationServiceJpa.class, DataSourceH2Config.class,
		DataSourceMySQLConfig.class })
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

		Cotisation nouvelleCotisation = new Cotisation("PAT", "patronal", new BigDecimal("0.50"),
				new BigDecimal("0.20"));
		cotisationService.sauvegarder(nouvelleCotisation);

		// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation
		// via la méthode lister

		List<Cotisation> cotisations = cotisationService.lister();
		for (Cotisation c : cotisations) {
			assertEquals("PAT", c.getCode());
			assertEquals("patronal", c.getLibelle());
			assertEquals(new BigDecimal("0.50"), c.getTauxSalarial());
			assertEquals(new BigDecimal("0.20"), c.getTauxPatronal());

			nouvelleCotisation.setId(c.getId());

		}

		nouvelleCotisation.setLibelle("salarial");
		cotisationService.mettreAJour(nouvelleCotisation);

		cotisations = cotisationService.lister();

		for (Cotisation c : cotisations) {

			assertEquals("salarial", c.getLibelle());
		}

		

	}
}
