/**
 * 
 */
package dev.paie.service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Grade;
import dev.paie.repository.GradeRepository;
import dev.paie.util.PaieUtils;

/**
 * @author Alexis Darcy
 *
 */
@Service
public class GradeServiceDataJpa implements GradeService {

	@Autowired
	private GradeRepository gradeRepository;

	@Autowired
	private PaieUtils paieUtils;

	@Override
	public void sauvegarder(Grade nouveauGrade) {
		gradeRepository.save(nouveauGrade);
	}


	@Override
	public void mettreAJour(Grade grade) {
		gradeRepository.save(grade);
	}


	@Override
	public void supprimer(Grade grade) {
		gradeRepository.delete(grade);
	}

	@Override
	public List<Grade> lister() {
		return gradeRepository.findAll();
	}

	@Override
	@Transactional
	public Map<Grade, String> salaireAnnuel() {
		Map<Grade, String> mapSalaireAnnuel = new TreeMap<Grade, String>(Comparator.comparing(Grade::getCode));
		gradeRepository.findAll()
				.forEach(g -> {
					String salaireAnnuel = paieUtils.formaterBigDecimal(
							g.getNbHeuresBase().multiply(g.getTauxBase()).multiply(new BigDecimal("12")));
					mapSalaireAnnuel.put(g, g.getCode() + " - " + salaireAnnuel);
				});

		return mapSalaireAnnuel;
	}
}
