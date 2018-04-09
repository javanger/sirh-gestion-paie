package dev.paie.web.controller;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.service.CalculerRemunerationService;

@Controller
@RequestMapping("/bulletins")

public class BulletinController {

	@Autowired
	private PeriodeRepository periodeRepo;

	@Autowired
	private RemunerationEmployeRepository employeRepository;
	@Autowired
	private BulletinSalaireRepository bulletinRepo;

	@Autowired
	private CalculerRemunerationService calculerRem;


	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView creerBulletin() {
		// (g1, g2) -> g1.calculerSalaire().compareTo(g2.calculerSalaire())

		Map<Integer, String> periodesMap = new TreeMap<>();

		periodeRepo.findAll().forEach(g -> {
			periodesMap.put(g.getId(), g.getDateDebut().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " - "
					+ g.getDateFin().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		});
		

		// Création du model
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/creerBulletin");
		// Ajout des objets à au model
		mv.addObject("bulletin", new BulletinSalaire());
		mv.addObject("periodes", periodesMap);
		mv.addObject("employes", employeRepository.findAll());


		return mv;
	}


	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public String submitForm(@ModelAttribute("bulletin") BulletinSalaire bulletinSalaire) {
		bulletinSalaire.setDateCreation(ZonedDateTime.now());
		bulletinRepo.save(bulletinSalaire);
		
		return "redirect:/mvc/bulletins/lister";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	@Secured({ "ROLE_UTILISATEUR", "ROLE_ADMINISTRATEUR" })
	@Transactional
	public ModelAndView listerBulletin() {

		Map<BulletinSalaire, ResultatCalculRemuneration> calculMap = new HashMap<BulletinSalaire, ResultatCalculRemuneration>();
		bulletinRepo.findAllWithCotisations().forEach(s -> {
			calculMap.put(s, calculerRem.calculer(s));
		});

		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/listerBulletin");

		mv.addObject("bulletins", calculMap);

		return mv;
	}


}