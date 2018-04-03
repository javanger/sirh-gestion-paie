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
	void sauvegarder(Grade nouveauGrade);
	void mettreAJour(Grade grade);
	List<Grade> lister();
	void supprimer(Grade supprimerGrade);
}
