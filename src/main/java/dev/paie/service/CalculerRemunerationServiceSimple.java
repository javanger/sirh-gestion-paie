package dev.paie.service;

import java.math.BigDecimal;
import java.util.Optional;

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

		Optional<BigDecimal> totalRetenueSalarial = bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsNonImposables().stream().filter(c -> c.getTauxSalarial() != null)
				.map(c -> c.getTauxSalarial().multiply(salaireBrut)).reduce((total, taux) -> total.add(taux));

		resultatCalculRemuneration.setTotalRetenueSalarial(paieUtils.formaterBigDecimal(totalRetenueSalarial.get()).toString());

		Optional<BigDecimal> totalCotisationPatronal = bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsNonImposables().stream().filter(c -> c.getTauxPatronal() != null)
				.map(c -> c.getTauxPatronal().multiply(salaireBrut))
				.reduce((total, taux) -> total.add(taux));

		resultatCalculRemuneration.setTotalCotisationsPatronales(paieUtils.formaterBigDecimal(totalCotisationPatronal.get()).toString());

		String salaireArrondi = paieUtils.formaterBigDecimal(salaireBrut);
		String retenueSalaireArrondi = paieUtils.formaterBigDecimal(totalRetenueSalarial.get());
		BigDecimal salaire = new BigDecimal(salaireArrondi);
		BigDecimal retenuSalaire = new BigDecimal(retenueSalaireArrondi);
		BigDecimal netImposable = salaire.subtract(retenuSalaire);

		resultatCalculRemuneration.setNetImposable(paieUtils.formaterBigDecimal(netImposable).toString());

		BigDecimal netAPayer = netImposable.subtract((bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsImposables().stream().filter(c -> c.getTauxSalarial() != null)
				.map(c -> c.getTauxSalarial().multiply(salaireBrut))
				.reduce((total, taux) -> total.add(taux))).get());

		resultatCalculRemuneration.setNetAPayer(paieUtils.formaterBigDecimal(netAPayer).toString());

		return resultatCalculRemuneration;
	}

}
