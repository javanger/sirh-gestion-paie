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
	 * Fonction qui sauvegarde un nouveau grade en base
	 * @param nouveauGrade Grade a enregistrer
	 */
	void sauvegarder(Grade nouveauGrade);
	/**
	 * Fonctoin qui met a jour un grade en base
	 * @param grade Grade a modifier
	 */
	void mettreAJour(Grade grade);
	/**
	 * Retourne la liste des grades qui sont en base
	 * @return Une liste de grade
	 */
	List<Grade> lister();
	/**
	 * Supprime un grade en base
	 * @param supprimerGrade Grade a supprimer
	 */
	void supprimer(Grade supprimerGrade);
}
