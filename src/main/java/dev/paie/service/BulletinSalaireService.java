/**
 * 
 */
package dev.paie.service;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.entite.CotisationCalculer;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.util.PaieUtils;

/**
 * @author GOBERT Guillaume
 *
 */
@Component
public class BulletinSalaireService {

	@Autowired
	BulletinSalaireRepository bulletinRepository;
	@Autowired
	CalculerRemunerationServiceSimple calculRemunerationService;
	@Autowired
	PaieUtils paieUtils;
	BulletinSalaire bulletin;

	public List<BulletinSalaire> list() {
		return bulletinRepository.findAll();
	}

	public void save(BulletinSalaire bulletin) {
		bulletin.setCreation(ZonedDateTime.now());
		bulletinRepository.save(bulletin);
	}

	public BulletinSalaire get(Integer idBulletin) {
		return bulletinRepository.findById(idBulletin);
	}

	@Transactional
	public TreeMap<BulletinSalaire, ResultatCalculRemuneration> calculAll() {
		TreeMap<BulletinSalaire, ResultatCalculRemuneration> mapCalcul = new TreeMap<>(
				Comparator.comparing(BulletinSalaire::getCreation));
		bulletinRepository.findAll().forEach(b -> {
			mapCalcul.put(b, calculRemunerationService.calculer(b));
		});
		return mapCalcul;
	}

	@Transactional
	public ResultatCalculRemuneration calculOne(Integer idBulletin) {
		ResultatCalculRemuneration calcul = new ResultatCalculRemuneration();
		calcul = calculRemunerationService.calculer(bulletinRepository.findOne(idBulletin));
		return calcul;
	}

	@Transactional
	public List<CotisationCalculer> totalImposable(ResultatCalculRemuneration resultat, Integer idBulletin) {
		List<CotisationCalculer> totalRetenue = new ArrayList<>();
		bulletin = bulletinRepository.findById(idBulletin);

		for (Cotisation cotisation : bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsImposables()) {
			CotisationCalculer cotisationCalcul = new CotisationCalculer();
			cotisationCalcul.setCotisation(cotisation);
			if (cotisation.getTauxSalarial() == null) {
				cotisationCalcul.setMontantSalarial("0.00");
			} else {
				BigDecimal montantSalarial = cotisation.getTauxSalarial()
						.multiply(new BigDecimal(resultat.getSalaireBrut()));
				cotisationCalcul.setMontantSalarial(paieUtils.formaterBigDecimal(montantSalarial));
			}
			if (cotisation.getTauxPatronal() == null) {
				cotisationCalcul.setCotisationPatronal("0.00");
			} else {
				BigDecimal cotisationPatronal = cotisation.getTauxPatronal()
						.multiply(new BigDecimal(resultat.getSalaireBrut()));
				cotisationCalcul.setCotisationPatronal(paieUtils.formaterBigDecimal(cotisationPatronal));
			}

			totalRetenue.add(cotisationCalcul);
		}
		return totalRetenue;

	}

	@Transactional
	public List<CotisationCalculer> total(ResultatCalculRemuneration resultat, Integer idBulletin) {
		List<CotisationCalculer> totalRetenue = new ArrayList<>();
		bulletin = bulletinRepository.findById(idBulletin);

		for (Cotisation cotisation : bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsNonImposables()) {
			CotisationCalculer cotisationCalcul = new CotisationCalculer();
			cotisationCalcul.setCotisation(cotisation);
			if (cotisation.getTauxSalarial() == null) {
				cotisationCalcul.setMontantSalarial("0.00");
			} else {
				BigDecimal montantSalarial = cotisation.getTauxSalarial()
						.multiply(new BigDecimal(resultat.getSalaireBrut()));
				cotisationCalcul.setMontantSalarial(paieUtils.formaterBigDecimal(montantSalarial));
			}
			if (cotisation.getTauxPatronal() == null) {
				cotisationCalcul.setCotisationPatronal("0.00");
			} else {
				BigDecimal cotisationPatronal = cotisation.getTauxPatronal()
						.multiply(new BigDecimal(resultat.getSalaireBrut()));
				cotisationCalcul.setCotisationPatronal(paieUtils.formaterBigDecimal(cotisationPatronal));
			}
			totalRetenue.add(cotisationCalcul);
		}
		return totalRetenue;

	}
}
