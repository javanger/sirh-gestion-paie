/**
 * 
 */
package dev.paie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.paie.entite.Cotisation;
import dev.paie.repository.CotisationRepository;

/**
 * @author GOBERT Guillaume
 *
 */
@Component
public class CotisationService {

	@Autowired
	CotisationRepository cotisationRepository;

	public List<Cotisation> list() {
		return cotisationRepository.findAll();
	}

	public void save(Cotisation cotisation) {
		cotisationRepository.save(cotisation);
	}

}
