/**
 * 
 */
package test_dev.paie.service;

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
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Cotisation;
import dev.paie.service.CotisationServiceInterface;

/**
 * @author GOBERT Guillaume
 *
 */
@ContextConfiguration(classes = { JpaConfig.class, DataSourceH2Config.class, ServicesConfig.class })
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {
	@Autowired
	private CotisationServiceInterface cotisationService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		//sauvegarder une nouvelle cotisation
		Cotisation cotisation = new Cotisation();

		cotisation.setCode("CO_01");
		cotisation.setLibelle("Cotisation Folie");
		cotisation.setTauxPatronal(new BigDecimal(10.95));
		cotisation.setTauxSalarial(new BigDecimal(6.66));

		cotisationService.sauvegarder(cotisation);
		//vérifier qu'il est possible de récupérer la nouvelle cotisation
		// via la méthode lister
		List<Cotisation> lesCotisations = cotisationService.lister();
		lesCotisations.stream().forEach(lc -> {
			assertEquals(lc.getCode(), "CO_01");
			assertEquals(lc.getLibelle(), "Cotisation Folie");
			assert new BigDecimal("10.95").compareTo(lc.getTauxPatronal()) == 0;
			assert new BigDecimal("6.66").compareTo(lc.getTauxSalarial()) == 0;
		});

		//modifier une cotisation

		cotisation.setLibelle("Folie");
		cotisation.setTauxPatronal(new BigDecimal(16.95));
		cotisation.setTauxSalarial(new BigDecimal(1.95));

		cotisationService.mettreAJour(cotisation);

		//vérifier que les modifications sont bien prises en compte via la
		// méthode lister

		List<Cotisation> lesNewCotisations = cotisationService.lister();
		lesNewCotisations.stream().forEach(lnc -> {
			assertEquals(lnc.getLibelle(), "Folie");
			assert new BigDecimal("16.95").compareTo(lnc.getTauxPatronal()) == 0;
			assert new BigDecimal("1.95").compareTo(lnc.getTauxSalarial()) == 0;
		});
		
		//supprimer une cotisation
		cotisationService.supprimer(cotisation);
	}
}
