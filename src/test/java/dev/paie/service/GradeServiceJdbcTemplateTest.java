package dev.paie.service;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceH2Config;
import dev.paie.config.DataSourceMySQLConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Grade;

@ContextConfiguration(classes = { DataSourceH2Config.class, ServicesConfig.class, DataSourceMySQLConfig.class})

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
		
		// TODO vérifier qu'il est possible de récupérer le nouveau grade via la // méthode lister
		
		
		assertEquals("abc", gradeService.findByCode("abc").getCode());
		assert new BigDecimal("15.00").compareTo(gradeService.findByCode("abc").getNbHeuresBase()) == 0;
		assert new BigDecimal("13.00").compareTo(gradeService.findByCode("abc").getTauxBase()) == 0;
		
				
		//Optional<Grade> gradeRes = gradeService.lister().stream().filter(g -> g.getCode().equals("abc")).findFirst();
		//assertTrue("pas trouvé abc", gradeRes.isPresent());
		
		// TODO modifier un grade
		gradeService.mettreAJour(new Grade (3, "casp", new BigDecimal("80"), new BigDecimal("56")));
		
		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode lister
		//Optional<Grade> gradeModif = gradeService.lister().stream().filter(g -> g.getCode().equals("casp")).findFirst();
		//assertTrue("pas trouvé casp", gradeModif.isPresent());
		assertEquals("casp", gradeService.findByCode("casp").getCode());
		assert new BigDecimal("80.00").compareTo(gradeService.findByCode("casp").getNbHeuresBase()) == 0;
		assert new BigDecimal("56.00").compareTo(gradeService.findByCode("casp").getTauxBase()) == 0;
		
	}
}