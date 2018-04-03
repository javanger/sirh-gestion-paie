package _dev.paie.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceH2Config;
import dev.paie.config.JpaConfig;
import dev.paie.entite.Cotisation;
import dev.paie.service.CotisationService;
import dev.paie.service.CotisationServiceJpa;

/**
 * @author Emmanuel
 *
 */
// TODO compléter la configuration
@ContextConfiguration(classes = { CotisationServiceJpa.class, JpaConfig.class, DataSourceH2Config.class })
// Configuration JUnit pour que Spring prenne la main sur le cycle de vie du test
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {
	@Autowired
	private CotisationService cotisationService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {

		BigDecimal bigDecimal = new BigDecimal("10.00");
		Cotisation cotisation = new Cotisation("COT", "Cotisation", bigDecimal, bigDecimal);

		// TODO sauvegarder une nouvelle cotisation
		cotisationService.sauvegarder(cotisation);

		// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation
		// via la méthode lister
		List<Cotisation> cotisations = cotisationService.lister();

		assertNotNull(cotisations);

		for (Cotisation c : cotisations) {
			assertEquals("COT", c.getCode());
			assertEquals("Cotisation", c.getLibelle());
			assertEquals(bigDecimal, c.getTauxPatronal());
			assertEquals(bigDecimal, c.getTauxSalarial());

			cotisation.setId(c.getId());
		}

		// TODO modifier une cotisation
		cotisation.setCode("COTCOT");
		cotisationService.mettreAJour(cotisation);

		cotisations = cotisationService.lister();

		assertNotNull(cotisations);

		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode lister
		for (Cotisation c : cotisations) {
			assertEquals("COTCOT", c.getCode());
			assertEquals("Cotisation", c.getLibelle());
			assertEquals(bigDecimal, c.getTauxPatronal());
			assertEquals(bigDecimal, c.getTauxSalarial());
		}

	}
}
