/**
 * 
 */
package dev.paie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.Periode;
import dev.paie.repository.PeriodeRepository;

/**
 * @author Alexis Darcy
 *
 */
@Service
public class PeriodeServiceDataJpa implements PeriodeService {

	@Autowired
	private PeriodeRepository periodeRepository;

	@Override
	public void sauvegarder(Periode nouvellePeriode) {
		periodeRepository.save(nouvellePeriode);
	}

	@Override
	public void mettreAJour(Periode periode) {
		periodeRepository.save(periode);
	}

	@Override
	public void supprimer(Periode periode) {
		periodeRepository.delete(periode);
	}

	@Override
	public List<Periode> lister() {
		return periodeRepository.findAll();
	}

}
