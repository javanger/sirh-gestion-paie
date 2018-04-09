/**
 * 
 */
package dev.paie.web.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Periode;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.service.CalculerRemunerationService;

/**
 * @author Emmanuel
 *
 */
@Controller
@RequestMapping("/bulletins")
public class BulletinController {
	
	@Autowired
	private RemunerationEmployeRepository remunerationEmployeRepository;
	
	@Autowired
	private PeriodeRepository periodeRepository;
	
	@Autowired
	private BulletinSalaireRepository bulletinSalaireRepository;
	
	@Autowired
	private CalculerRemunerationService	 calculRemuneration;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView creerBulletin() {
		
		ModelAndView mv = new ModelAndView();

		List<RemunerationEmploye> employes = remunerationEmployeRepository.findAll();
		List<Periode> periodes = periodeRepository.findAll();

		mv.setViewName("bulletins/creerBulletin");

		mv.addObject("employes", employes);
		mv.addObject("periodes", periodes);

		mv.addObject("bulletinSalaire", new BulletinSalaire());

		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView submitForm(@ModelAttribute("bulletinSalaire") BulletinSalaire bulletinSalaire) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("redirect:lister");
		
		bulletinSalaire.setDateCreation(LocalDateTime.now());
		
		bulletinSalaireRepository.save(bulletinSalaire);
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	@Secured({"ROLE_UTILISATEUR", "ROLE_ADMINISTRATEUR"})
	@Transactional
	public ModelAndView listerBulletins() {
		
		ModelAndView mv = new ModelAndView();
		
		List<BulletinSalaire> bulletins = bulletinSalaireRepository.findAllWithCotisations();

		Map<BulletinSalaire, ResultatCalculRemuneration> listeBulletins = new HashMap<>();
		
		for(BulletinSalaire bulletin: bulletins) {
			listeBulletins.put(bulletin, calculRemuneration.calculer(bulletin));
		}
		
		
		mv.setViewName("bulletins/listerBulletins");

		mv.addObject("bulletins", listeBulletins);

		return mv;
	}
	
}
