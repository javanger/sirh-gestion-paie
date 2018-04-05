/**
 * 
 */
package dev.paie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.Grade;
import dev.paie.repository.GradeRepository;

/**
 * @author Alexis Darcy
 *
 */
@Service
public class GradeServiceDataJpa implements GradeService {

	@Autowired
	private GradeRepository gradeRepository;

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

}
