/**
 * 
 */
package dev.paie.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.service.BulletinSalaireService;
import dev.paie.service.PeriodeService;
import dev.paie.service.RemunerationEmployeService;

/**
 * @author Alexis Darcy
 *
 */
@Controller
@RequestMapping("/bulletins")
public class BulletinSalaireController {

	@Autowired
	private RemunerationEmployeService remunerationEmployeServiceJpa;

	@Autowired
	private PeriodeService periodeServiceDataJpa;

	@Autowired
	private BulletinSalaireService bulletinServiceDataJpa;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerBulletin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/creerBulletin");
		mv.addObject("employes", remunerationEmployeServiceJpa.lister());
		mv.addObject("periodes", periodeServiceDataJpa.lister());
		mv.addObject("bulletinSalaire", new BulletinSalaire());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public ModelAndView ajouterEmploye(@ModelAttribute("bulletinSalaire") BulletinSalaire bulletinSalaire) {
		bulletinServiceDataJpa.sauvegarder(bulletinSalaire);
		return listerEmploye();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/listerBulletin");
		mv.addObject("bulletinServices", bulletinServiceDataJpa.calcul());
		return mv;
	}
}