package dev.paie.service;



import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceMySQLConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Grade;

@ContextConfiguration(classes = { DataSourceMySQLConfig.class, ServicesConfig.class})

@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {
	
	
	@Autowired
	private GradeService gradeService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		
		// TODO sauvegarder un nouveau grade
		Grade grade = new Grade();
		grade.setCode("abc");
		grade.setNbHeuresBase(new BigDecimal("15"));
		grade.setTauxBase(new BigDecimal("13"));
		gradeService.sauvegarder(grade);
		
		assertTrue("liste null", gradeService.lister() != null);
		assertTrue("liste vide", gradeService.lister().isEmpty() == false);
		
		// TODO vérifier qu'il est possible de récupérer le nouveau grade via la
		Optional<Grade> gradeRes = gradeService.lister().stream().filter(g -> g.getCode().equals("abc")).findFirst();
		assertTrue("pas trouvé abc", gradeRes.isPresent());
		
		gradeService.lister();
		
		gradeService.mettreAJour(new Grade (1, "capp", new BigDecimal("220"), new BigDecimal("256")));
		// méthode lister
		// TODO modifier un grade
		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode lister
	}
}