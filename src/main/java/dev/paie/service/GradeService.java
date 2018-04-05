/**
 * 
 */
package dev.paie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.paie.entite.Grade;
import dev.paie.repository.GradeRepository;

/**
 * @author Axel B.
 *
 */
@Component
public class GradeService {

	@Autowired
	GradeRepository gradeRepository;

	public List<Grade> list() {
		return gradeRepository.findAll();
	}

	public void save(Grade grade) {
		gradeRepository.save(grade);
	}

}
