/**
 * 
 */
package dev.paie.service;

import java.util.List;

import dev.paie.entite.Grade;

/**
 * @author Axel B.
 *
 */
public interface GradeService {
	void sauvegarder(Grade nouveauGrade);

	void mettreAJour(Grade grade);

	List<Grade> lister();

	/**
	 * @param res
	 */
	void supprimer(Grade res);

}
