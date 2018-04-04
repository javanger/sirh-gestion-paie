/**
 * 
 */
package dev.paie.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceH2;
import dev.paie.config.JpaConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;

/**
 * @author Axel B.
 *
 */
// Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { ServicesConfig.class, JpaConfig.class, DataSourceH2.class })
// Configuration JUnit pour que Spring prenne la main sur le cycle de vie du test
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {

	@Autowired
	private AvantageRepository avantageRepository;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// TODO sauvegarder un nouvel avantage
		Avantage avantage = new Avantage();

		avantage.setCode("test");
		avantage.setNom("libelleTest");
		avantage.setMontant(new BigDecimal("100"));
		avantageRepository.save(avantage);

		// vérifier qu'il est possible de récupérer la nouvelle avantage
		// via la méthode lister

		Avantage findAvantage = avantageRepository.findOne(avantage.getId());
		assertTrue(!findAvantage.equals(null));
		// modifier un avantage

		avantage.setNom("testLibelle");
		avantage.setMontant(new BigDecimal("99"));
		avantageRepository.save(avantage);

		// vérifier que les modifications sont bien prises en compte via la
		// méthode lister

		Avantage findAvantageModif = avantageRepository.findOne(avantage.getId());
		assertEquals(findAvantageModif.getNom(), "testLibelle");
		assert new BigDecimal("99").compareTo(findAvantageModif.getMontant()) == 0;

		Avantage findAvantageCode = avantageRepository.findByCode(avantage.getCode());
		assertTrue(!findAvantageCode.equals(null));

		avantageRepository.delete(avantage.getId());
	}
}