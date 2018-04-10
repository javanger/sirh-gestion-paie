package dev.paie.repository;

import static org.junit.Assert.assertEquals;

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

//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { ServicesConfig.class, JpaConfig.class, DataSourceH2.class })
//Configuration JUnit pour que Spring prenne la main sur le cycle de vie du test
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {

	@Autowired
	private AvantageRepository avantageRepository;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// sauvegarder un nouvel avantage
		//  vérifier qu'il est possible de récupérer le nouvel avantage via la méthode findOne
		Avantage avantage= new Avantage();
		avantage.setCode("1548");
		avantage.setNom("Test");
		avantage.setMontant(new BigDecimal("456.30"));
		
		avantageRepository.save(avantage);
		
		assertEquals("1548", avantageRepository.findByCode("1548").getCode());
		assertEquals("Test", avantageRepository.findByCode("1548").getNom());
		assert new BigDecimal("456.30").compareTo(avantageRepository.findByCode("1548").getMontant()) == 0;
		
		// modifier un avantage
		// vérifier que les modifications sont bien prises en compte via la méthode findOne
		avantage.setCode("13649");
		avantage.setNom("Modifié");
		avantage.setMontant(new BigDecimal("649216.2"));
		
		avantageRepository.save(avantage);
		
		assertEquals("13649", avantageRepository.findByCode("13649").getCode());
		assertEquals("Modifié", avantageRepository.findByCode("13649").getNom());
		assert new BigDecimal("649216.2").compareTo(avantageRepository.findByCode("13649").getMontant()) == 0;
		
		avantageRepository.delete(avantage.getId());
	}
}
