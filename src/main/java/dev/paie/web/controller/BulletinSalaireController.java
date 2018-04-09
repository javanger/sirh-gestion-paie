package dev.paie.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Periode;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.service.BulletinSalaireService;

@Controller
@RequestMapping("/bulletins")
public class BulletinSalaireController {

	@Autowired
	private PeriodeRepository periodeRepository;

	@Autowired
	private RemunerationEmployeRepository remunerationEmployeRepository;

	@Autowired
	private BulletinSalaireRepository bulletinsSalaireRepository;

	@Autowired
	private BulletinSalaireService bulletinSalaireService;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView creerEmploye() {

		ModelAndView mv = new ModelAndView();


		List<RemunerationEmploye> remunerationEmploye = remunerationEmployeRepository.findAll();
		List<Periode> periodes = periodeRepository.findAll();
		mv.setViewName("bulletins/creerBulletin");
		mv.addObject("periodes", periodes);
		mv.addObject("bulletinSalaire", new BulletinSalaire());
		mv.addObject("remunerationEmploye", remunerationEmploye);

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public String submitForm(@ModelAttribute("bulletinSalaire") BulletinSalaire bulletinSalaire) {
		bulletinsSalaireRepository.save(bulletinSalaire);
		return "redirect:/mvc/bulletins/lister";

	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	@Secured({ "ROLE_UTILISATEUR", "ROLE_ADMINISTRATEUR" })
	public ModelAndView listerBulletins() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/listerBulletin");
		mv.addObject("bulletinSalaire", bulletinSalaireService.calcul());
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/visualiser")
	@Secured({ "ROLE_UTILISATEUR", "ROLE_ADMINISTRATEUR" })
	public ModelAndView visualiserBulletins() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/visualiserBulletins");
		mv.addObject("bulletinSalaire", new BulletinSalaire());
		return mv;
	}

}


