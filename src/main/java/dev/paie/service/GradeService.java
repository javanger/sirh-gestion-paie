package dev.paie.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.paie.repository.GradeRepository;
import dev.paie.util.PaieUtils;

@Component
public class GradeService {

	@Autowired
	private PaieUtils paieUtils;
	@Autowired
	private GradeRepository gradeRepository;

	public void calculerSalaire() {
		gradeRepository.findAll().stream().forEach(
				g -> {
					g.setSalaire(" - " + paieUtils.formaterBigDecimal(
								g.getNbHeuresBase().multiply(g.getTauxBase()).multiply(new BigDecimal("12")))
							+ " € / an");
					gradeRepository.save(g);
				});
	}

}
