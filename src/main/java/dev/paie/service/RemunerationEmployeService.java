/**
 * 
 */
package dev.paie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.RemunerationEmployeRepository;

/**
 * @author Axel B.
 *
 */
@Component
public class RemunerationEmployeService {

	@Autowired
	RemunerationEmployeRepository remunerationEmployeRepository;

	public List<RemunerationEmploye> list() {
		return remunerationEmployeRepository.findAll();
	}

	public void save(RemunerationEmploye remunerationEmploye) {
		remunerationEmployeRepository.save(remunerationEmploye);
	}

}
