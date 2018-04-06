package dev.paie.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceH2;
import dev.paie.config.JeuxDeDonneesConfig;
import dev.paie.entite.Grade;

//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { GradeServiceJdbcTemplate.class, JeuxDeDonneesConfig.class, DataSourceH2.class })
// Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
// test
@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {

	@Autowired
	private GradeServiceInterface gradeService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		//  sauvegarder un nouveau grade
		//  vérifier qu'il est possible de récupérer le nouveau grade via la
		// méthode lister
		Grade grade = new Grade();
		grade.setCode("1548484");
		grade.setNbHeuresBase(new BigDecimal("2665.3"));
		grade.setTauxBase(new BigDecimal("36.30"));

		gradeService.sauvegarder(grade);

		assertEquals("1548484", gradeService.findGradeByCode("1548484").getCode());
		assert new BigDecimal("2665.3").compareTo(gradeService.findGradeByCode("1548484").getNbHeuresBase()) == 0;
		assert new BigDecimal("36.30").compareTo(gradeService.findGradeByCode("1548484").getTauxBase()) == 0;

		//  modifier un grade
		//  vérifier que les modifications sont bien prises en compte via la
		// méthode lister

		Grade gradeUpdate = new Grade();
		gradeUpdate.setCode("154");
		gradeUpdate.setNbHeuresBase(new BigDecimal("26.3"));
		gradeUpdate.setTauxBase(new BigDecimal("12.3"));

		gradeService.mettreAJour(gradeUpdate, "1548484");

		assertEquals("154", gradeService.findGradeByCode("154").getCode());
		assert new BigDecimal("26.3").compareTo(gradeService.findGradeByCode("154").getNbHeuresBase()) == 0;
		assert new BigDecimal("12.3").compareTo(gradeService.findGradeByCode("154").getTauxBase()) == 0;


	}
}
