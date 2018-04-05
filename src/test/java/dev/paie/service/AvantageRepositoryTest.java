/**
 * 
 */
package dev.paie.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

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
import dev.paie.repository.AvantageRepository;

/**
 * @author Alexis Darcy
 *
 */
//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { ServicesConfig.class, JpaConfig.class, DataSourceH2Config.class })

//Configuration JUnit pour que Spring prenne la main sur le cycle de vie du test
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {

	 @Autowired 
	 private AvantageRepository avantageRepository;   
	 
	 @Test   
	 public void test_sauvegarder_lister_mettre_a_jour() {  
		 
		 Avantage avantage = new Avantage();
		 Avantage avantageTest = new Avantage();
		 
		 avantage.setCode("Test");
		 avantage.setNom("Libelle");
		 avantage.setMontant(new BigDecimal("15.58"));
		 
		 avantageRepository.save(avantage);
		 
		 avantageTest = avantageRepository.findOne(avantage.getId());
		 
		 assertFalse(avantageTest == null );
		 
		 avantage.setCode("Test");
		 avantage.setNom("Libelle2");
		 avantage.setMontant(new BigDecimal("17.58"));
		 
		 avantageRepository.save(avantage);
		 
		 avantageTest = avantageRepository.findByCode(avantage.getCode());
		 
		 assertThat(avantageTest.getId(), equalTo(avantage.getId()));
		 assertThat(avantageTest.getCode(), equalTo(avantage.getCode()));
		 assertThat(avantageTest.getNom(), equalTo(avantage.getNom()));
		 assertThat(avantageTest.getMontant(), equalTo(avantage.getMontant())); 
		 
		 
		 
		 avantageRepository.delete(avantageTest);
		 
	} 
}
