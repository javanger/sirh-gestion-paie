/**
 * 
 */
package dev.paie.service;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.RemunerationEmployeRepository;

/**
 * @author GOBERT Guillaume
 *
 */
@Component
public class RemunerationEmployeService {

	@Autowired
	RemunerationEmployeRepository remunerationEmpRep;

	public List<RemunerationEmploye> list() {
		return remunerationEmpRep.findAll();
	}

	public void save(RemunerationEmploye remEmp) {
		remEmp.setCreation(ZonedDateTime.now());
		remunerationEmpRep.save(remEmp);
	}

}
