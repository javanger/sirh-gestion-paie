package dev.paie.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceH2Config;
import dev.paie.config.DataSourceMySQLConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Grade;

//Sélection des classes de configuration Spring à utiliser lors du test
//@ContextConfiguration(classes = { DataSourceMySQLConfig.class, GradeServiceJdbcTemplate.class })
@ContextConfiguration(classes = { DataSourceH2Config.class, GradeServiceJdbcTemplate.class })
// Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
// test
@RunWith(SpringRunner.class)

// TODO compléter la configuration
public class GradeServiceJdbcTemplateTest {
	@Autowired
	private GradeService gradeService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
//		 TODO sauvegarder un nouveau grade
		Grade nouveauGrade = new Grade("dev", new BigDecimal(12.50), new BigDecimal(1.50));
		gradeService.sauvegarder(nouveauGrade);

		List<Grade> grades = gradeService.lister();

		for (Grade c : grades) {

			assert new BigDecimal("12.50").compareTo(c.getNbHeuresBase()) == 0;
			assert new BigDecimal("1.50").compareTo(c.getTauxBase()) == 0;
			nouveauGrade.setId(c.getId());
		}

		assert new BigDecimal("12.50").compareTo(gradeService.findGradeByCode("dev").getNbHeuresBase()) == 0;

		nouveauGrade.setTauxBase(new BigDecimal(15.00));
		nouveauGrade.setNbHeuresBase(new BigDecimal(1.50));
		nouveauGrade.setCode("pop");

		gradeService.mettreAJour(nouveauGrade);

		assert new BigDecimal("15.00").compareTo(gradeService.findGradeByCode("pop").getTauxBase()) == 0;
		assert new BigDecimal("1.50").compareTo(gradeService.findGradeByCode("pop").getNbHeuresBase()) == 0;

		gradeService.deleteGrade("dev");
		gradeService.deleteGrade("pop");

		

	}
}
