/**
 * 
 */
package test_dev.paie.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceH2Config;
import dev.paie.config.DataSourceMySQLConfig;
import dev.paie.entite.Grade;
import dev.paie.service.GradeServiceInterface;
import dev.paie.service.GradeServiceJdbcTemplate;

/**
 * @author GOBERT Guillaume
 *
 */
@ContextConfiguration(classes = { DataSourceH2Config.class, GradeServiceJdbcTemplate.class })
@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {

	@Autowired
	private GradeServiceInterface gradeService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// sauvegarde d'un nouveau grade
		Grade grade = new Grade();
		
		grade.setCode("CG-01");
		grade.setNbHeuresBase(new BigDecimal(125.25));
		grade.setTauxBase(new BigDecimal(10.60));
		
		gradeService.sauvegarder(grade);
		// vérification qu'il est possible de récupérer le nouveau grade via la
		// méthode lister
		List<Grade> lesGrades = gradeService.lister();
		lesGrades.stream().forEach(lg -> {
			assertEquals(lg.getCode(), "CG-01");
			assert new BigDecimal("125.25").compareTo(lg.getNbHeuresBase()) == 0;
			assert new BigDecimal("10.60").compareTo(lg.getTauxBase()) == 0;
		});	
		
		//modification d'un grade
		
		grade.setNbHeuresBase(new BigDecimal(6852.97));
		grade.setTauxBase(new BigDecimal(16.82));
		gradeService.mettreAJour(grade);
		//vérification que les modifications sont bien prises en compte via la
		// méthode lister
		List<Grade> lesNewGrades = gradeService.lister();
		lesNewGrades.stream().forEach(lng -> {
			assert new BigDecimal("6852.97").compareTo(lng.getNbHeuresBase()) == 0;
			assert new BigDecimal("16.82").compareTo(lng.getTauxBase()) == 0;
		});
		
		//suppresion d'un grade
		gradeService.supprimer(grade);
	}

}
