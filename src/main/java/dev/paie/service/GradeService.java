/**
 * 
 */
package dev.paie.service;

import java.util.List;

import dev.paie.entite.Grade;

/**
 * @author Alexis Darcy
 *
 */
public interface GradeService {
	
	/** ajoute un grade
	 * @param nouveauGrade : a ajouter
	 */
	void sauvegarder(Grade nouveauGrade);

	/** modifie un grade
	 * @param grade : a modifier
	 */
	void mettreAJour(Grade grade);
	
	/** supprime un grade
	 * @param grade : a supprimer
	 */
	void supprimer(Grade grade);

	/** retourne tous les grades de la table
	 * @return tout les grades
	 */
	List<Grade> lister();
}