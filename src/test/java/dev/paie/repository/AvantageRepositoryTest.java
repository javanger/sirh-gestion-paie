package dev.paie.repository;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceH2Config;
import dev.paie.config.JpaConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;

/**
 * @author Emmanuel
 *
 */
@ContextConfiguration(classes = { ServicesConfig.class, JpaConfig.class, DataSourceH2Config.class })
//Configuration JUnit pour que Spring prenne la main sur le cycle de vie du test
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {

	@Autowired
	private AvantageRepository avantageRepository;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		
		BigDecimal bigDecimal = new BigDecimal("10.00");
		Avantage avantage = new Avantage("AVANTAGE", "Un Avantage", bigDecimal);
		
		// TODO sauvegarder un nouvel avantage
		avantageRepository.save(avantage);
		
		// TODO vérifier qu'il est possible de récupérer le nouvel avantage via
		// la méthode findOne
		Avantage findAvantage = avantageRepository.findOne(1);
		
		assertEquals(avantage.getCode(), findAvantage.getCode());
		
		// TODO modifier un avantage
		findAvantage.setCode("EGATNAVA");
		
		avantageRepository.save(findAvantage);
		
		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode findOne
		findAvantage = avantageRepository.findOne(1);
		
		assertEquals("EGATNAVA", findAvantage.getCode());
	}
}
