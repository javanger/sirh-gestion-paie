/**
 * 
 */
package dev.paie.service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Grade;
import dev.paie.repository.GradeRepository;
import dev.paie.util.PaieUtils;

/**
 * @author GOBERT Guillaume
 *
 */
@Component
public class GradeService {

	@Autowired
	GradeRepository gradeRepository;
	@Autowired
	PaieUtils paieUtils;

	public List<Grade> list() {
		return gradeRepository.findAll();
	}

	public void save(Grade grade) {
		gradeRepository.save(grade);
	}

	@Transactional
	public TreeMap<Grade, String> salaireAnnuel() {
		TreeMap<Grade, String> gradeSalaire = new TreeMap<>(Comparator.comparing(Grade::getCode));
		gradeRepository.findAll().forEach(g -> {
			String annuel = paieUtils.formaterBigDecimal(g.getNbHeuresBase().multiply(g.getTauxBase()).multiply(new BigDecimal(12)));
			gradeSalaire.put(g, g.getCode() + " - " + annuel);
		});
		return gradeSalaire;
	}
}
