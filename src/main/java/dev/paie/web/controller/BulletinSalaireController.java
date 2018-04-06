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
import dev.paie.service.CalculerRemunerationServiceSimple;
import dev.paie.service.PeriodeService;
import dev.paie.service.RemunerationEmployeService;

/**
 * @author Axel B.
 *
 */
@Controller
@RequestMapping("/bulletins")
public class BulletinSalaireController {

	@Autowired
	PeriodeService periodeS;

	@Autowired
	BulletinSalaireService bulletinSalaireS;

	@Autowired
	RemunerationEmployeService remunerationS;

	@Autowired
	CalculerRemunerationServiceSimple calculRemuneration;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerBulletin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/creerBulletin");

		mv.addObject("periodes", periodeS.list());
		mv.addObject("remunerations", remunerationS.list());
		mv.addObject("bulletinSalaire", new BulletinSalaire());

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public ModelAndView submitForm(@ModelAttribute("bulletinSalaire") BulletinSalaire bulletinSalaire) {
		ModelAndView mv = new ModelAndView();
		bulletinSalaireS.save(bulletinSalaire);
		mv.setViewName("redirect:lister");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView lister() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/listerBulletin");
		mv.addObject("bulletin", bulletinSalaireS.calcul());
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/visualiser")
	public ModelAndView visualiser() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/visualiserBulletin");
		mv.addObject("bulletin", bulletinSalaireS.calcul());
		return mv;
	}
}
