package dev.paie.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {

	@Autowired
	private PaieUtils paie;

	@Override
	@Transactional
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		
		 ResultatCalculRemuneration resultat = new ResultatCalculRemuneration();
		 
		 
		 BigDecimal salaireBase = bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase().multiply(bulletin.getRemunerationEmploye().getGrade().getTauxBase()); 
		 
		 BigDecimal salaireBrutNonArrondi = salaireBase.add(bulletin.getPrimeExceptionnelle());
		 
		 String salaireBrutStr = paie.formaterBigDecimal(salaireBrutNonArrondi);
		 
		 BigDecimal salaireBrutArrondi = new BigDecimal(salaireBrutStr);
		 
		 resultat.setSalaireBrut(salaireBrutStr);
		 
		 
		 Optional<BigDecimal> totalRetSal = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables().stream()
				 .filter(p->p.getTauxSalarial()!=null)
				 .map(p->p.getTauxSalarial().multiply(salaireBrutArrondi))
				 .reduce((b1,b2)->b1.add(b2));
		 
		 resultat.setTotalRetenueSalarial(paie.formaterBigDecimal(totalRetSal.get()));
		 
		 Optional<BigDecimal> totalCotisPatronal = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables().stream()
				 .filter(p->p.getTauxPatronal()!=null)
				 .map(p->p.getTauxPatronal().multiply(salaireBrutArrondi))
				 .reduce((b1,b2)->b1.add(b2)) ;
		 
		 resultat.setTotalCotisationsPatronales(paie.formaterBigDecimal(totalCotisPatronal.get()));
		 
		 BigDecimal netImposable = salaireBrutArrondi.subtract(new BigDecimal(resultat.getTotalRetenueSalarial()));
		 resultat.setNetImposable(paie.formaterBigDecimal(netImposable));
		 
		 Optional<BigDecimal> somme = bulletin.getRemunerationEmploye().getProfilRemuneration()
				 .getCotisationsImposables().stream()
				 .filter(p->p.getTauxSalarial()!=null)
				 .map(p->p.getTauxSalarial().multiply(salaireBrutArrondi))
				 .reduce((b1,b2)->b1.add(b2));
		 BigDecimal netAPayer = netImposable.subtract(somme.get());
		 resultat.setNetAPayer(paie.formaterBigDecimal(netAPayer));
		 
		return resultat;
		
		
	}

}
