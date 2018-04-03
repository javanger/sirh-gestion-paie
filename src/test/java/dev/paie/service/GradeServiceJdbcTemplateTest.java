package dev.paie.service;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceH2Config;
import dev.paie.entite.Grade;

//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { GradeServiceJdbcTemplate.class, DataSourceH2Config.class })
// Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {

	// il y a une seule implementation donc on peut utiliser l'interface pour
	// l'injection
	// sinon il faut spécifier l'implementaion à utiliser dans la config via
	// @qualifier
	@Autowired
	private GradeService gradeService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		Grade newGrade = new Grade();
		newGrade.setCode("GRD1");
		newGrade.setNbHeuresBase(new BigDecimal("45"));
		newGrade.setTauxBase(new BigDecimal("1.2"));

		// sauvegarder un nouveau grade
		gradeService.sauvegarder(newGrade);

		// vérifier qu'il est possible de récupérer le nouveau grade via la
		// méthode lister
		List<Grade> list = gradeService.lister();

		assertTrue("La liste est null", list != null);
		assertTrue("La liste est vide", !list.isEmpty());
		Optional<Grade> grade = gradeService.lister().stream().filter(g -> g.getCode().equals("GRD1")).findFirst();
		assertTrue("Impoosible de trouver l'element GRD1", grade.isPresent());

		// modifier un grade
		Grade oldGrade = grade.get();
		oldGrade.setCode("GRD2");
		oldGrade.setNbHeuresBase(new BigDecimal("88"));
		oldGrade.setTauxBase(new BigDecimal("4.5"));

		gradeService.mettreAJour(oldGrade);
		// vérifier que les modifications sont bien prises en compte via la
		// méthode lister
		Optional<Grade> grade2 = gradeService.lister().stream().filter(g -> g.getCode().equals("GRD2")).findFirst();
		assertTrue("Impoosible de trouver l'element GRD2", grade2.isPresent());
	}
}
