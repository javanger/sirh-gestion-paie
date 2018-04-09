/**
 * 
 */
package dev.paie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.paie.entite.Periode;
import dev.paie.repository.PeriodeRepository;

/**
 * @author Axel B.
 *
 */
@Component
public class PeriodeService {

	@Autowired
	PeriodeRepository periodeRepository;

	public List<Periode> list() {
		return periodeRepository.findAll();
	}

	public void save(Periode p) {
		periodeRepository.save(p);
	}

}
