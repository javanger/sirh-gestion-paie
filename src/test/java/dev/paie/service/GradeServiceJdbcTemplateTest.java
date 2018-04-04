package dev.paie.service;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceH2SQLConfig;
import dev.paie.config.JpaConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Grade;

@ContextConfiguration(classes = { GradeServiceJdbcTemplate.class , DataSourceH2SQLConfig.class})

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
		
		
		Grade gradeCree = gradeService.findByCode("abc");
		assertEquals("abc", gradeCree.getCode());
		assert new BigDecimal("15.00").compareTo(gradeCree.getNbHeuresBase()) == 0;
		assert new BigDecimal("13.00").compareTo(gradeCree.getTauxBase()) == 0;
		
				
		//Optional<Grade> gradeRes = gradeService.lister().stream().filter(g -> g.getCode().equals("abc")).findFirst();
		//assertTrue("pas trouvé abc", gradeRes.isPresent());
		
		// TODO modifier un grade
		gradeCree.setCode("casp");
		gradeCree.setNbHeuresBase(new BigDecimal("80"));
		gradeCree.setTauxBase(new BigDecimal("56"));
		gradeService.mettreAJour(gradeCree);
		
		assertEquals("casp", gradeService.findByCode("casp").getCode());
		assert new BigDecimal("80.00").compareTo(gradeService.findByCode("casp").getNbHeuresBase()) == 0;
		assert new BigDecimal("56.00").compareTo(gradeService.findByCode("casp").getTauxBase()) == 0;
		// TODO vérifier que les modifications sont bien prises en compte via la
				// méthode lister
				//Optional<Grade> gradeModif = gradeService.lister().stream().filter(g -> g.getCode().equals("casp")).findFirst();
				//assertTrue("pas trouvé casp", gradeModif.isPresent());
	}
}