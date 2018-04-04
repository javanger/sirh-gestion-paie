package dev.paie.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceH2Config;
import dev.paie.config.DataSourceMySQLConfig;
import dev.paie.config.JpaConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;
import dev.paie.service.CotisationServiceJpa;

@ContextConfiguration(classes = { ServicesConfig.class, DataSourceH2Config.class, DataSourceMySQLConfig.class })
// TODO compléter la configuration
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {
	@Autowired
	private AvantageRepository avantageRepository;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// TODO sauvegarder un nouvel avantage
		Avantage avantage = new Avantage();

		avantage.setCode("PO");
		avantage.setMontant(new BigDecimal("0.25"));
		avantage.setNom("poste");



		// TODO vérifier qu'il est possible de récupérer le nouvel avantage via
		// la méthode findOne
		avantageRepository.save(avantage);

		assertNotNull(avantageRepository.findOne(avantage.getId()));
		// TODO modifier un avantage
		avantage.setCode("PA");
		avantageRepository.save(avantage);
		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode findOne
		assertEquals(avantageRepository.findOne(avantage.getId()).getCode(), "PA");
	}
}