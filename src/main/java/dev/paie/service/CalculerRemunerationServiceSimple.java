package dev.paie.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {

	@Autowired
	private PaieUtils paieUtils;

	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		ResultatCalculRemuneration resultatCalculRemuneration = new ResultatCalculRemuneration();

		BigDecimal salaireBrut = (bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase()
				.multiply((bulletin.getRemunerationEmploye().getGrade().getTauxBase()))
				.add(bulletin.getPrimeExceptionnelle()));
		
		resultatCalculRemuneration.setSalaireBrut(paieUtils.formaterBigDecimal(salaireBrut));
		
		
		
		

		return resultatCalculRemuneration;
	}

}
