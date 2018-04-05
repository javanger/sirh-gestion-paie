package dev.paie.web.controller;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.repository.BulletinRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/bulletins")
public class BulletinSalaireController {

	@Autowired
	BulletinRepository bulletinRepository;

	@Autowired
	private RemunerationEmployeRepository remunerationRepository;

	@Autowired
	private PeriodeRepository periodeRepository;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/creerBulletin");

		mv.addObject("bulletinSalaire", new BulletinSalaire());
		mv.addObject("remuneration", remunerationRepository.findAll());
		mv.addObject("periode", periodeRepository.findAll());
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(Model model) {
		model.addAttribute("bulletinSalaire", new BulletinSalaire());

		return "bulletins/creerBulletin";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public ModelAndView submitForm(@ModelAttribute("bulletinSalaire") BulletinSalaire bulletinSalaire) {
		bulletinSalaire.setDateCreation(ZonedDateTime.now());
		bulletinRepository.save(bulletinSalaire);
		return listerBulletin();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerBulletin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/listerBulletin");

		mv.addObject("bulletin", bulletinRepository.findAll());
		return mv;
	}
}
