/**
 * 
 */
package dev.paie.services;

import java.util.List;

import dev.paie.entites.Grade;

/**
 * @author Kevin M.
 *
 */
public interface GradeService {
	void sauvegarder(Grade nouveauGrade);
	void mettreAJour(Grade grade);
	List<Grade> lister();
}
