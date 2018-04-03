package dev.paie.repositories;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entites.Avantage;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { ServicesConfig.class })
public class AvantageRepositoryTest {

	@Autowired
	AvantageRepository repository;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// Enregistrer un avantage
		Avantage avantage = new Avantage();
		avantage.setCode("AV01");
		avantage.setMontant(new BigDecimal("300.50"));
		avantage.setNom("Avantage numero 1");

		// vérifier qu'il est possible de récupérer le nouvel avantage via la
		// méthode findOne
		Avantage gotAvantage = repository.findOne(1);
		assertTrue("pas trouvé", gotAvantage != null);
	}

}
