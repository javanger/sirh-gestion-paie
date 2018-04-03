package dev.paie.services;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.JeuxDeDonneesConfig;
import dev.paie.entites.BulletinSalaire;
import dev.paie.entites.ResultatCalculRemuneration;
import dev.paie.services.CalculerRemunerationService;
import dev.paie.services.CalculerRemunerationServiceSimple;
import dev.paie.utils.PaieUtils;

// Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { CalculerRemunerationServiceSimple.class, PaieUtils.class, JeuxDeDonneesConfig.class })

// Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
@RunWith(SpringRunner.class)

public class CalculerRemunerationServiceSimpleTest {

	@Autowired
	private CalculerRemunerationService remunerationService;

	@Autowired
	BulletinSalaire bulletin1;

	@Test
	public void test_not_null_remunerationService() {
		assert null != remunerationService;
	}

	@Test
	public void test_not_null_bulletin1() {
		assert null != bulletin1;
	}

	@Test
	public void test_calculer() {
		// TODO remplacer null par un objet bulletin
		ResultatCalculRemuneration resultat = remunerationService.calculer(bulletin1);
		assertThat(resultat.getSalaireBrut(), equalTo("2683.30"));
		// assertThat(resultat.getTotalRetenueSalarial(), equalTo("517.08"));
		// assertThat(resultat.getTotalCotisationsPatronales(),
		// equalTo("1096.13"));
		// assertThat(resultat.getNetImposable(), equalTo("2166.22"));
		// assertThat(resultat.getNetAPayer(), equalTo("2088.41"));
	}

}
