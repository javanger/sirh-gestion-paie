package dev.paie.services;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceH2Config;
import dev.paie.config.JpaConfig;
import dev.paie.entites.Cotisation;

@ContextConfiguration(classes = { CotisationServiceJpa.class, DataSourceH2Config.class, JpaConfig.class })
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {

	@Autowired
	private CotisationServiceJpa cotisationService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// sauvegarder une nouvelle cotisation
		Cotisation cotisation = new Cotisation();
		cotisation.setCode("CO01");
		cotisation.setLibelle("Coti 01");
		cotisation.setTauxPatronal(new BigDecimal("45.2"));
		cotisation.setTauxSalarial(new BigDecimal("14.25"));
		cotisationService.sauvegarder(cotisation);

		// vérifier qu'il est possible de récupérer la nouvelle cotisation via
		// la
		// méthode lister
		List<Cotisation> cotisations = cotisationService.lister();
		assertTrue("list null", cotisations != null);
		assertTrue("list vide", cotisations.isEmpty() == false);

		System.out.println("list count =" + cotisations.size());
		Optional<Cotisation> cotisation1 = cotisations.stream().filter(c -> c.getCode().equals("CO01")).findFirst();
		System.out.println("element prensent : " + cotisation1.get().getCode());
		assertTrue("create : element non trouvé 3", cotisation1.isPresent());
		assertTrue("create : CO01 non trouvé", cotisation1.get().getCode().equals("CO01"));

		// modifier une cotisation
		Cotisation current = cotisation1.get();
		current.setCode("CO02");
		current.setLibelle("Coti 02");
		current.setTauxPatronal(new BigDecimal("55.2"));
		current.setTauxSalarial(new BigDecimal("20.25"));
		cotisationService.mettreAjour(current);

		// vérifier que les modifications sont bien prises en compte via la
		// méthode
		// lister
		cotisations = cotisationService.lister();
		assertTrue("list null", cotisations != null);
		assertTrue("list vide", cotisations.isEmpty() == false);

		Optional<Cotisation> cotisation2 = cotisations.stream().filter(c -> c.getCode().equals("CO02")).findFirst();
		assertTrue("update : element non trouvé ", cotisation2.isPresent());
		assertTrue("update : CO02 non trouvé", cotisation1.get().getCode().equals("CO02"));
	}

}
