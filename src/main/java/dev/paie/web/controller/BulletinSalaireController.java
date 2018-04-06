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
		bulletinSalaireS.save(bulletinSalaire);
		return creerBulletin();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerBulletin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/listerBulletin");

		mv.addObject("bulletinSalaires", bulletinSalaireS.list());
		return mv;
	}
}
