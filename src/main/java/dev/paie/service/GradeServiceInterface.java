package dev.paie.service;

import java.util.List;

import dev.paie.entite.Grade;

public interface GradeServiceInterface {

	void sauvegarder(Grade nouveauGrade);
	void mettreAJour(Grade grade, String code);
	List<Grade> lister();
	Grade findGradeByCode( String code);
}
