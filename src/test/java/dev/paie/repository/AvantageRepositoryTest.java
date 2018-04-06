package dev.paie.repository;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceH2JpaConfig;
import dev.paie.config.JpaConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;


@ContextConfiguration(classes = { JpaConfig.class, DataSourceH2JpaConfig.class, ServicesConfig.class})
//TODO compléter la configuration
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {
	@Autowired
	private AvantageRepository avantageRepository;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// TODO sauvegarder un nouvel avantage
		Avantage avantage = new Avantage();
		avantage.setCode("der");
		avantage.setNom("nom");
		avantage.setMontant(new BigDecimal("11.00"));
		avantageRepository.save(avantage);
		// TODO vérifier qu'il est possible de récupérer le nouvel avantage via
		// la méthode findOne
	
		
		Avantage avantageCreer = avantageRepository.findByCode("der");
		assertEquals("der", avantageCreer.getCode());
		assertEquals("nom", avantageCreer.getNom());
		assert new BigDecimal ("11.00").compareTo(avantageCreer.getMontant()) == 0;
		// TODO modifier un avantage
				
		avantageCreer.setCode("deri");
		avantageCreer.setNom("nom1");
		avantageCreer.setMontant(new BigDecimal("42.00"));
		avantageRepository.save(avantageCreer);
		
		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode findOne
		assertEquals("deri", avantageCreer.getCode());
		assertEquals("nom1", avantageCreer.getNom());
		assert new BigDecimal ("42.00").compareTo(avantageCreer.getMontant()) == 0;
		
	}
}
