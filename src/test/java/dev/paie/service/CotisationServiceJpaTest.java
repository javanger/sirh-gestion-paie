package dev.paie.service;

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
import dev.paie.entite.Cotisation;

@ContextConfiguration(classes = { CotisationServiceJpa.class, DataSourceH2Config.class, JpaConfig.class })
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {

	@Autowired
	private CotisationService cotisationService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// TODO sauvegarder une nouvelle cotisation
		Cotisation cotisation = new Cotisation();
		cotisation.setCode("CO01");
		cotisation.setLibelle("Coti 01");
		cotisation.setTauxPatronal(new BigDecimal("45.2"));
		cotisation.setTauxSalarial(new BigDecimal("14.25"));
		cotisationService.sauvegarder(cotisation);

		// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation via la
		// méthode lister
		List<Cotisation> cotisations = cotisationService.lister();
		assertTrue("list null", cotisations != null);
		assertTrue("list vide", cotisations.isEmpty() == false);

		Optional<Cotisation> cotisation1 = cotisations.stream().filter(c -> c.getCode().equals("CO01")).findFirst();
		assertTrue("element non trouvé", cotisation1.isPresent());

		// TODO modifier une cotisation
		Cotisation current = cotisation1.get();
		current.setCode("CO02");
		current.setLibelle("Coti 02");
		current.setTauxPatronal(new BigDecimal("55.2"));
		current.setTauxSalarial(new BigDecimal("20.25"));
		cotisationService.mettreAjour(current);

		// TODO vérifier que les modifications sont bien prises en compte via la méthode
		// lister
		Optional<Cotisation> cotisation2 = cotisations.stream().filter(c -> c.getCode().equals("CO02")).findFirst();
		assertTrue("element non trouvé", cotisation2.isPresent());
	}

}
