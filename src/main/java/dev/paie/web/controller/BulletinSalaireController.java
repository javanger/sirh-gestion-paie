package dev.paie.web.controller;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.repository.BulletinRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.service.CalculerRemunerationService;

@Controller
@RequestMapping("/bulletins")
public class BulletinSalaireController {

	@Autowired
	BulletinRepository bulletinRepository;

	@Autowired
	private RemunerationEmployeRepository remunerationRepository;

	@Autowired
	private PeriodeRepository periodeRepository;

	@Autowired
	private CalculerRemunerationService calculer;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/creerBulletin");

		mv.addObject("bulletinSalaire", new BulletinSalaire());
		mv.addObject("remuneration", remunerationRepository.findAll());
		mv.addObject("periode", periodeRepository.findAll());
		return mv;
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
		Map<BulletinSalaire, ResultatCalculRemuneration> resultat = new HashMap<>();
		bulletinRepository.findAllWithCotisations().forEach(b -> resultat.put(b, calculer.calculer(b)));

		mv.addObject("map", resultat);
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/visualiser/{id}")
	public ModelAndView visualiserBulletin(@PathVariable Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/visualiserBulletin");


		mv.addObject("bulletin", bulletinRepository.findById(id));
		mv.addObject("resultat", calculer.calculer(bulletinRepository.findById(id)));
		return mv;
	}
}
