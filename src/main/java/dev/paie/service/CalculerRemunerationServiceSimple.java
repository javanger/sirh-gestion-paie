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
	private PaieUtils paie;

	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		
		 ResultatCalculRemuneration resultat = new ResultatCalculRemuneration();
		 
		 
		 BigDecimal salaireBase = bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase().multiply(bulletin.getRemunerationEmploye().getGrade().getTauxBase()); 
		 
		 BigDecimal salaireBrut = salaireBase.add(bulletin.getPrimeExceptionnelle());
		 
		 resultat.setSalaireBrut(paie.formaterBigDecimal(salaireBrut));
		 
		 
		 Optional<BigDecimal> totalRetSal = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables().stream()
				 .filter(p->p.getTauxSalarial()!=null)
				 .map(p->p.getTauxSalarial().multiply(salaireBrut))
				 .reduce((b1,b2)->b1.add(b2));
		 
		 resultat.setTotalRetenueSalarial(paie.formaterBigDecimal(totalRetSal.get()));
		 
		 Optional<BigDecimal> totalCotisPatronal = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables().stream()
				 .filter(p->p.getTauxPatronal()!=null)
				 .map(p->p.getTauxPatronal().multiply(salaireBrut))
				 .reduce((b1,b2)->b1.add(b2)) ;
		 
		 resultat.setTotalCotisationsPatronales(paie.formaterBigDecimal(totalCotisPatronal.get()));
		 
		 BigDecimal netImposable = salaireBrut.subtract(totalRetSal.get());
		 resultat.setNetImposable(paie.formaterBigDecimal(netImposable));
		 
		return resultat;
		
		
	}

}
