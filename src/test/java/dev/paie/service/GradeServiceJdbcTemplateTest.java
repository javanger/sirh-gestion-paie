package dev.paie.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Grade;

//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { ServicesConfig.class, JeuxDeDonneesConfig.class })
//Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
//test
@RunWith(SpringRunner.class)

//TODO compléter la configuration
public class GradeServiceJdbcTemplateTest {
	@Autowired
	private GradeService gradeService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// TODO sauvegarder un nouveau grade
		Grade nouveauGrade = new Grade(1, "dev", new BigDecimal(12.50), new BigDecimal(0.5));
		gradeService.sauvegarder(nouveauGrade);
		
		// TODO vérifier qu'il est possible de récupérer le nouveau grade via la
		// méthode lister
		assertThat(gradeService.lister().size(), equalTo("1"));
		
		// TODO modifier un grade
		Grade modifGrade = gradeService.findGradeById(1);
		modifGrade.setNbHeuresBase(new BigDecimal(0.3));
		
		assertThat(modifGrade.getNbHeuresBase(), equalTo("0.3"));
		
		
		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode lister
		
		
	}
}
