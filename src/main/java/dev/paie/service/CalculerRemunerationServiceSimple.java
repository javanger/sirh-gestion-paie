/**
 * 
 */
package dev.paie.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

/**
 * @author Alexis Darcy
 *
 */
@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {

	@Autowired
	private PaieUtils paieUtils;

	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		ResultatCalculRemuneration result = new ResultatCalculRemuneration();
		// result.setSalaireBrut(paieUtils.formaterBigDecimal(bulletin.getRemunerationEmploye().getGrade()
		// .getNbHeuresBase().multiply(bulletin.getRemunerationEmploye().getGrade().getTauxBase())
		// .add(bulletin.getPrimeExceptionnelle())));
		result.setSalaireDeBase(paieUtils.formaterBigDecimal(bulletin.getRemunerationEmploye().getGrade()
				.getNbHeuresBase().multiply(bulletin.getRemunerationEmploye().getGrade().getTauxBase())));

		result.setSalaireBrut(paieUtils
				.formaterBigDecimal(new BigDecimal(result.getSalaireDeBase()).add(bulletin.getPrimeExceptionnelle())));

		Optional<BigDecimal> totalRetenueSalaire = bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsNonImposables().stream().filter(f -> f.getTauxSalarial() != null)
				.map(m -> m.getTauxSalarial()).reduce((b1, b2) -> b1.add(b2));

		result.setTotalRetenueSalarial(paieUtils
				.formaterBigDecimal(totalRetenueSalaire.get().multiply(new BigDecimal(result.getSalaireBrut()))));

		Optional<BigDecimal> totalRetenuePatronales = bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsNonImposables().stream().filter(f -> f.getTauxPatronal() != null)
				.map(m -> m.getTauxPatronal()).reduce((b1, b2) -> b1.add(b2));

		result.setTotalCotisationsPatronales(paieUtils
				.formaterBigDecimal(totalRetenuePatronales.get().multiply(new BigDecimal(result.getSalaireBrut()))));

		result.setNetImposable(paieUtils.formaterBigDecimal(
				new BigDecimal(result.getSalaireBrut()).subtract(new BigDecimal(result.getTotalRetenueSalarial()))));

		Optional<BigDecimal> netAPayer = bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsImposables().stream().filter(f -> f.getTauxSalarial() != null)
				.map(m -> m.getTauxSalarial().multiply(new BigDecimal(result.getSalaireBrut()))).reduce((b1, b2) -> b1.add(b2));

		result.setNetAPayer(paieUtils.formaterBigDecimal(new BigDecimal(result.getNetImposable()).subtract(netAPayer.get())));

		return result;
	}

}
