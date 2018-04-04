package dev.paie.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceH2Config;
import dev.paie.config.JpaConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Cotisation;

//TODO compléter la configuration
//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { DataSourceH2Config.class, JpaConfig.class, ServicesConfig.class })
// Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
// test
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {

	@Autowired
	private CotisationService cotisationService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// TODO sauvegarder une nouvelle cotisation
		// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation
		// via la méthode lister

		Cotisation cotisation = new Cotisation();

		cotisation.setCode("beta");
		cotisation.setLibelle("dicotomie");
		cotisation.setTauxPatronal(new BigDecimal("145.15"));
		cotisation.setTauxSalarial(new BigDecimal("4569.25"));
		cotisationService.sauvegarder(cotisation);

		assertTrue("list vide", cotisationService.lister().isEmpty() == false);

		// TODO modifier un grade
		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode lister

		Cotisation cotisationModifie = cotisationService.lister().stream().filter(p -> p.getCode().equals("beta")).findFirst().get();

		//Cotisation newCotisation = new Cotisation();
		//cotisation.setCode("beta");
		cotisationModifie.setLibelle("nouveau");
		cotisationModifie.setTauxPatronal(new BigDecimal("12547.15"));
		cotisationModifie.setTauxSalarial(new BigDecimal("74123.25"));

		cotisationService.mettreAJour(cotisationModifie);
	
		//Cotisation cotisationModifie = cotisationService.lister().stream().filter(p -> p.getCode().equals("beta")).findFirst().get();
		/*System.out.println(cotisationModifie.getCode());
		System.out.println(cotisationModifie.getTauxPatronal());
		System.out.println(cotisationModifie.getLibelle());*/
		
		List<Cotisation> list = cotisationService.lister();
		for (Cotisation c : list) {
			System.out.println(c.getCode());
			System.out.println(c.getLibelle());
			System.out.println(c.getTauxPatronal());
			System.out.println(c.getTauxSalarial());
		}
		assert new BigDecimal("12547.15").compareTo(cotisation.getTauxPatronal())==0;
		assert new BigDecimal("74123.25").compareTo(cotisation.getTauxSalarial()) == 0;
		assertEquals("nouveau", cotisation.getLibelle());
	}

}
