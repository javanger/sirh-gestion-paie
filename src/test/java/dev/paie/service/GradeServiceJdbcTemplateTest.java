package dev.paie.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceH2Config;
import dev.paie.config.DataSourceMySQLConfig;
import dev.paie.config.JpaConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Grade;

//TODO compléter la configuration
//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { DataSourceH2Config.class, GradeServiceJdbcTemplate.class })
// Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
// test
@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {
	@Autowired
	private GradeService gradeService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// TODO sauvegarder un nouveau grade
		// TODO vérifier qu'il est possible de récupérer le nouveau grade via la
		// méthode lister

		Grade grade = new Grade();
		
		grade.setCode("jdb");
		grade.setNbHeuresBase(new BigDecimal("100.00"));
		grade.setTauxBase(new BigDecimal("50.00"));

		gradeService.sauvegarder(grade);

		assertTrue("list vide", gradeService.lister().isEmpty() == false);

		// TODO modifier un grade
		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode lister
		Grade gradeModifie = gradeService.lister().stream().filter(p->p.getCode().equals("jdb")).findFirst().get();
		//Grade newGrade = new Grade();
		gradeModifie.setCode("triban");
		gradeModifie.setNbHeuresBase(new BigDecimal("154.89"));
		gradeModifie.setTauxBase(new BigDecimal("45.98"));
		
		gradeService.mettreAJour(gradeModifie, "jdb");

		
		assert new BigDecimal("154.89").compareTo(gradeModifie.getNbHeuresBase()) == 0;
		assert new BigDecimal("45.98").compareTo(gradeModifie.getTauxBase())== 0;
		
	

	} 
}