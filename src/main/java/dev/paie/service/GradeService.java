/**
 * 
 */
package dev.paie.service;

import java.util.List;

import dev.paie.entite.Grade;

/**
 * @author GOBERT Guillaume
 *
 */
public interface GradeService {
	/**
	 * 
	 * @param nouveauGrade
	 */
	void sauvegarder(Grade nouveauGrade);
	/**
	 * 
	 * @param grade
	 */
	void mettreAJour(Grade grade);
	/**
	 * 
	 * @return
	 */
	List<Grade> lister();
	/**
	 * 
	 * @param supprimerGrade
	 */
	void supprimer(Grade supprimerGrade);
}
