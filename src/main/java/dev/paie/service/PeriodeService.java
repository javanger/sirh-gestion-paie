/**
 * 
 */
package dev.paie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.paie.entite.Periode;

/**
 * @author Alexis Darcy
 *
 */
@Service
public interface PeriodeService {
	
	void sauvegarder(Periode nouvellePeriode);

	void mettreAJour(Periode periode);

	void supprimer(Periode periode);
	
	List<Periode> lister();
	
}