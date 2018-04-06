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

import dev.paie.config.DataSourceH2Config;
import dev.paie.config.JpaConfig;
import dev.paie.entite.Cotisation;

/**
 * @author Alexis Darcy
 *
 */
// Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = {  DataSourceH2Config.class, JpaConfig.class, CotisationServiceJpa.class })

// Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
// test
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {

	@Autowired
	private CotisationService cotisationService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		Cotisation cotisation = new Cotisation();
		List<Cotisation> listCotisation = new ArrayList<Cotisation>();

		cotisation.setCode("Test");
		cotisation.setLibelle("LibelleTest");
		cotisation.setTauxSalarial(new BigDecimal("0.75"));
		cotisation.setTauxPatronal(new BigDecimal("1.45"));

		cotisationService.sauvegarder(cotisation);

		listCotisation = cotisationService.lister();
		for (Cotisation c : listCotisation) {
			if (c.getCode().equals("Test")) {
				assertThat(c.getCode(), equalTo("Test"));
				assertThat(c.getLibelle(), equalTo("LibelleTest"));
				assert new BigDecimal("0.75").compareTo(c.getTauxSalarial()) == 0;
				assert new BigDecimal("1.45").compareTo(c.getTauxPatronal()) == 0;
			}
		}
		
		cotisation.setCode("Test");
		cotisation.setLibelle("LibelleTest2");
		cotisation.setTauxSalarial(new BigDecimal("1.68"));
		cotisation.setTauxPatronal(new BigDecimal("2.40"));

		cotisationService.mettreAJour(cotisation);

		listCotisation = cotisationService.lister();
		for (Cotisation c : listCotisation) {
			if (c.getCode().equals("Test")) {
				assertThat(c.getCode(), equalTo("Test"));
				assertThat(c.getLibelle(), equalTo("LibelleTest2"));
				assert new BigDecimal("1.68").compareTo(c.getTauxSalarial()) == 0;
				assert new BigDecimal("2.40").compareTo(c.getTauxPatronal()) == 0;
				cotisationService.supprimer(c);
			}
		}
		
		listCotisation = cotisationService.lister();
		assertThat(listCotisation.size(), equalTo(0));
	}
}
