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

//	@Test
//	public void test_mappage_entites() {
//		repo
//	}
	
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// Enregistrer un avantage
		Avantage avantage = new Avantage();
		avantage.setCode("AV01");
		avantage.setMontant(new BigDecimal("300.50"));
		avantage.setNom("Avantage numero 1");

		repository.save(avantage);
		
		// vérifier qu'il est possible de récupérer le nouvel avantage via la
		// méthode findOne
		Avantage gotAvantage = repository.findOne(1);
		assertTrue("null object", gotAvantage != null);
		assertTrue("pas trouvé AV01", gotAvantage != null);
		System.out.println(gotAvantage.getMontant());
		
		// Modifier un avantage
		gotAvantage.setCode("AV02");
		gotAvantage.setMontant(new BigDecimal("355.50"));
		gotAvantage.setNom("Avantage numero 2");

		repository.saveAndFlush(gotAvantage);
		
		// vérifier les modifications via la méthode findOne
		gotAvantage = repository.findOne(1);
		assertTrue("null object", gotAvantage != null);
		assertTrue("pas trouvé AV02", gotAvantage != null);
		System.out.println(gotAvantage.getMontant());	
		
		// test find by code
		Avantage av02 = repository.findByCode("AV02");
		assertTrue("findByCode: AV02 introuvable", av02 != null);
		System.out.println(av02.getCode());
	}

}
