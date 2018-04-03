package dev.paie.service;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceMySQLConfig;
import dev.paie.config.JeuxDeDonneesConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Grade;

@ContextConfiguration(classes = { ServicesConfig.class, JeuxDeDonneesConfig.class, DataSourceMySQLConfig.class})

@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {
	
	//private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private GradeService gradeService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		
		Grade grade = new Grade();
		grade.setId(1);
		grade.setCode("abc");
		grade.setNbHeuresBase(new BigDecimal("15"));
		grade.setTauxBase(new BigDecimal("13"));
		gradeService.sauvegarder(grade);
		
		
		//gradeService.lister();
		/*
		assertThat(grade.getId(), equalTo("1"));
		assertThat(grade.getCode(), equalTo("abc"));
		assertThat(grade.getNbHeuresBase(), equalTo("15"));
		assertThat(grade.getTauxBase(), equalTo("13"));
		gradeService.lister();
		*/
		
		// TODO sauvegarder un nouveau grade
		// TODO vérifier qu'il est possible de récupérer le nouveau grade via la
		// méthode lister
		// TODO modifier un grade
		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode lister
	}
}