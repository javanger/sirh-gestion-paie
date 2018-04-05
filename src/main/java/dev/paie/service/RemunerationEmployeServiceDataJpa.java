/**
 * 
 */
package dev.paie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.RemunerationEmployeRepository;

/**
 * @author Alexis Darcy
 *
 */
@Service
public class RemunerationEmployeServiceDataJpa implements RemunerationEmployeService {

	@Autowired
	private RemunerationEmployeRepository remunerationEmployeRepository;

	@Override
	public void sauvegarder(RemunerationEmploye nouveauRemunerationEmploye) {
		remunerationEmployeRepository.save(nouveauRemunerationEmploye);

	}

	@Override
	public void mettreAJour(RemunerationEmploye remunerationEmploye) {
		remunerationEmployeRepository.save(remunerationEmploye);

	}

	@Override
	public void supprimer(RemunerationEmploye remunerationEmploye) {
		remunerationEmployeRepository.delete(remunerationEmploye);
	}

	@Override
	public List<RemunerationEmploye> lister() {
		return remunerationEmployeRepository.findAll();
	}

}
