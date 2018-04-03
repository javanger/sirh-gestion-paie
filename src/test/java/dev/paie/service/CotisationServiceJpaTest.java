/**
 * 
 */
package dev.paie.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceMySQLConfig;
import dev.paie.config.JpaConfig;
import dev.paie.entite.Cotisation;

/**
 * @author Axel B.
 *
 */
@ContextConfiguration(classes = { DataSourceMySQLConfig.class,JpaConfig.class, CotisationServiceJpa.class })
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {

	@Autowired
	private CotisationService cotisationService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// sauvegarder une nouvelle cotisation
		Cotisation cot = new Cotisation();
		List<Cotisation> cotisations = new ArrayList<Cotisation>();
		List<Cotisation> listCotisation = new ArrayList<Cotisation>();

		cot.setCode("test");
		cot.setLibelle("libetest");
		cot.setTauxPatronal(new BigDecimal("0.5"));
		cot.setTauxSalarial(new BigDecimal("0.8"));

		cotisationService.sauvegarder(cot);

		// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation
		// via la méthode lister
		for (Cotisation c : cotisations) {
			if (c.getCode().equals("test")) {
				assertThat(c.getCode(), equalTo("test"));
				assert new BigDecimal("45").compareTo(c.getTauxPatronal()) == 0;
				assert new BigDecimal("50.2").compareTo(c.getTauxSalarial()) == 0;
			}
		}

		// TODO modifier une cotisation
		cot.setCode("test");
		cot.setLibelle("libelleTest");
		cot.setTauxPatronal(new BigDecimal("0.8"));
		cot.setTauxSalarial(new BigDecimal("1.2"));
		cotisationService.mettreAJour(cot);

		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode lister
		listCotisation = cotisationService.lister();
		for (Cotisation c : listCotisation) {
			if (c.getCode().equals("tester")) {
				assertThat(c.getCode(), equalTo("tester"));
				assert new BigDecimal("0.7").compareTo(c.getTauxPatronal()) == 0;
				assert new BigDecimal("1.1").compareTo(c.getTauxSalarial()) == 0;
				cotisationService.supprimer(cot);
			}
		}
		
		 listCotisation = cotisationService.lister();
		 assertThat(listCotisation.size(), equalTo(0));
	}
}