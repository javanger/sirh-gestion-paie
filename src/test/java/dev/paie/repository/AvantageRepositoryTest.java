package dev.paie.repository;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceH2EmptyConfig;
import dev.paie.config.DataSourceMySQLConfig;
import dev.paie.config.JpaConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;

//TODO compléter la configuration
//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { DataSourceH2EmptyConfig.class, ServicesConfig.class })
// Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
// test
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {
	@Autowired
	private AvantageRepository avantageRepository;

@Test
public void test_sauvegarder_lister_mettre_a_jour() {
//TODO sauvegarder un nouvel avantage
//TODO vérifier qu'il est possible de récupérer le nouvel avantage via la méthode findOne
	
	Avantage newAvantage = new Avantage();
	newAvantage.setCode("1548");
	newAvantage.setNom("Adrien");
	newAvantage.setMontant(new BigDecimal("15000.56"));
	avantageRepository.save(newAvantage);
	
	assert avantageRepository.findAll().stream().anyMatch(a -> a.getCode().equals("1548"));
	assert avantageRepository.findAll().stream().anyMatch(a -> a.getNom().equals("Adrien")); 
	assert avantageRepository.findAll().stream().anyMatch(a->a.getMontant().equals(new BigDecimal("15000.56")));
	
	//TODO modifier un avantage
	//TODO vérifier que les modifications sont bien prises en compte via la méthode findOne
	
	newAvantage.setCode("14789");
	newAvantage.setNom("Robert");
	newAvantage.setMontant(new BigDecimal("12360.25"));
	
	avantageRepository.save(newAvantage);
	
	assertEquals("14789", avantageRepository.findByCode("14789").getCode()); 
	assertEquals("Robert", avantageRepository.findByCode("14789").getNom());
	assertEquals(new BigDecimal("12360.25"), avantageRepository.findByCode("14789").getMontant());

	

	}
}
