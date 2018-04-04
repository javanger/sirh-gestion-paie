/**
 * 
 */
package dev.paie.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dev.paie.entites.Cotisation;
import dev.paie.repositories.CotisationRepository;

/**
 * @author Kevin M.
 *
 */
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	@Autowired
	CotisationRepository cRepo;
	
	/*
	 * (non-Javadoc)
	 * 
	 * 
	 * @see dev.paie.services.InitialiserDonneesService#initialiser()
	 */
	@Override
	public void initialiser() {
		System.out.println("Init :)");
		// extraire les grades du fichier xml
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("grades.xml", "entreprises.xml",
				"cotisations-imposables.xml", "cotisations-non-imposables.xml", "profils-remuneration.xml");
		Map<String, Cotisation> cotisations = context.getBeansOfType(Cotisation.class);
		cotisations.forEach((cle, valeur) -> {
			if (valeur != null)
				cRepo.save(valeur);
		});
	}
}
