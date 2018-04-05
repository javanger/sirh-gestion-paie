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
 * @author GOBERT Guillaume
 *
 */
@Controller
@RequestMapping("/bulletins")
public class BulletinController {

	@Autowired
	private PeriodeService periodeService;
	@Autowired
	private RemunerationEmployeService remunerationServ;
	@Autowired
	private BulletinSalaireService bulletinServ;
	@Autowired
	private CalculerRemunerationServiceSimple calculRemuneration;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/creerBulletin");
		mv.addObject("periodes", periodeService.list());
		mv.addObject("remunerations", remunerationServ.list());
		mv.addObject("bulletinSalaire", new BulletinSalaire());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public ModelAndView submitForm(@ModelAttribute("bulletinSalaire") BulletinSalaire bulletinSalaire) {
		bulletinServ.save(bulletinSalaire);
		return listerBulletin();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerBulletin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/listerBulletin");
		mv.addObject("bulletinSalaires", bulletinServ.calcul());
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/visualiser")
	public ModelAndView visualiserBulletin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/visualiserBulletin");
		return mv;
	}
}
