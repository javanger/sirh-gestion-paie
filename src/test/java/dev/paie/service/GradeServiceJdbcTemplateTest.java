/**
 * 
 */
package dev.paie.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceMariaDBConfig;
import dev.paie.entite.Grade;

/**
 * @author Alexis Darcy
 *
 */
//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = {DataSourceMariaDBConfig.class, GradeServiceJdbcTemplate.class})

//Configuration JUnit pour que Spring prenne la main sur le cycle de vie du test
@RunWith(SpringRunner.class)

public class GradeServiceJdbcTemplateTest {   
	
	@Autowired 
	private GradeService gradeService;
	
	@Test   
	public void test_sauvegarder_lister_mettre_a_jour() {  
		
		Grade grade = new Grade();
		List<Grade> listGrade = new ArrayList<Grade>();
		
		grade.setCode("Test");
		grade.setNbHeuresBase(new BigDecimal("151.67"));
		grade.setTauxBase(new BigDecimal("11.0984"));
		
		gradeService.sauvegarder(grade);  
		
		listGrade = gradeService.lister();
		for (Grade g : listGrade) {
			if(g.getCode().equals("Test")){
				assertThat(g.getCode(), equalTo("Test"));
				assert new BigDecimal("151.67").compareTo(g.getNbHeuresBase()) == 0;
				assert new BigDecimal("11.0984").compareTo(g.getTauxBase()) == 0;
			}
		}
		
		grade.setCode("Test");
		grade.setNbHeuresBase(new BigDecimal("153.67"));
		grade.setTauxBase(new BigDecimal("16.09"));
	
		gradeService.mettreAJour(grade); 
		
		listGrade = gradeService.lister();
		for (Grade g : listGrade) {
			if(g.getCode().equals("Test")){
				assertThat(g.getCode(), equalTo("Test"));
				assert new BigDecimal("153.67").compareTo(g.getNbHeuresBase()) == 0;
				assert new BigDecimal("16.09").compareTo(g.getTauxBase()) == 0;
			}
		}
		
		gradeService.supprimer(grade);
		
		listGrade = gradeService.lister();
		assertThat(listGrade.size(), equalTo(0));
	} 
}
