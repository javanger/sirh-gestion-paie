package dev.paie.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceH2Config;
import dev.paie.config.DataSourceMySQLConfig;
import dev.paie.entite.Grade;

/**
 * @author Emmanuel
 *
 */
@ContextConfiguration(classes = { DataSourceH2Config.class, GradeServiceJdbcTemplate.class })

@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {

	@Autowired
	private IGradeService gradeService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		
		BigDecimal bD = new BigDecimal("10");
		Grade grade = new Grade("Un Grade", bD, bD);
		
		// TODO sauvegarder un nouveau grade	
		gradeService.sauvegarder(grade);
		
		// TODO vérifier qu'il est possible de récupérer le nouveau grade via la méthode lister
		List<Grade> grades = gradeService.lister();
		
		assertNotNull(grades);
		
		for (Grade g : grades) {
			assertEquals("Un Grade", g.getCode());
			assertEquals(bD , g.getNbHeuresBase());
			assertEquals(bD , g.getTauxBase());
			
			grade.setId(g.getId());
		}
		
		// TODO modifier un grade	
		grade.setCode("Un nouveau");
		gradeService.mettreAJour(grade);
		
		// TODO vérifier que les modifications sont bien prises en compte via la méthode lister
		grades = gradeService.lister();
		
		assertNotNull(grades);
		
		for (Grade g : grades) {
			assertEquals("Un nouveau", g.getCode());
			assertEquals(bD , g.getNbHeuresBase());
			assertEquals(bD , g.getTauxBase());
		}
		
		gradeService.supprimer(grade);
		
	}
}