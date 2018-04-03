/**
 * 
 */
package dev.paie.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceMySQLConfig;
import dev.paie.entite.Grade;

/**
 * @author Axel B.
 *
 */

@ContextConfiguration(classes = { DataSourceMySQLConfig.class, GradeServiceJdbcTemplate.class })
@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {

	@Autowired
	private GradeService gradeService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {

		//  sauvegarder un nouveau grade
		List<Grade> grades = new ArrayList<Grade>();
		List<Grade> listGrade = new ArrayList<Grade>();
		Grade res = new Grade();
		
		res.setCode("test");
		res.setNbHeuresBase(new BigDecimal("35"));
		res.setTauxBase(new BigDecimal("0.2"));

		gradeService.sauvegarder(res);
		
		//  vérifier qu'il est possible de récupérer le nouveau grade via la
		// méthode lister

//		grades = gradeService.lister();

		for (Grade g : grades) {
			if (g.getCode().equals("test")) {
				assertThat(g.getCode(), equalTo("test"));
				assert new BigDecimal("45").compareTo(g.getNbHeuresBase()) == 0;
				assert new BigDecimal("50.2").compareTo(g.getTauxBase()) == 0;
			}
		}
		

		//  modifier un grade
		
		res.setCode("test");
		res.setNbHeuresBase(new BigDecimal("38"));
		res.setTauxBase(new BigDecimal("1.18"));
		gradeService.mettreAJour(res);
		
		//  vérifier que les modifications sont bien prises en compte via la
		// méthode lister
		
		
		listGrade = gradeService.lister();
		for (Grade g : grades) {
			if (g.getCode().equals("tester")) {
				assertThat(g.getCode(), equalTo("tester"));
				assert new BigDecimal("50").compareTo(g.getNbHeuresBase()) == 0;
				assert new BigDecimal("21.28").compareTo(g.getTauxBase()) == 0;

			}
		}
		
		gradeService.supprimer(res);
		listGrade = gradeService.lister();
		assertThat(listGrade.size(), equalTo(0));
		
	}

}
