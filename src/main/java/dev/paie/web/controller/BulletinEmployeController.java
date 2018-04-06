package dev.paie.web.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
@RequestMapping("/bulletins")
public class BulletinEmployeController {

	@Autowired
	private PeriodeRepository periodeRepository;
	@Autowired
	private RemunerationEmployeRepository remunerationEmployeRepository;
	@Autowired
	private BulletinSalaireRepository bulletinSalaireRepository;
	@Autowired
	private CalculerRemunerationService calculerRemunerationServiceSimple;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")

	public ModelAndView creerBulletin() {
		ModelAndView mv = new ModelAndView();
		List<Periode> periodes = periodeRepository.findAll();
		Map<Integer, String> periodeMap = new HashMap<>();
		for (Periode p : periodes) {
			periodeMap.put(p.getId(), p.getDateDebut() + "-" + p.getDateFin());
		}

		List<RemunerationEmploye> employes = remunerationEmployeRepository.findAll();
		mv.addObject("employes", employes);
		mv.addObject("periodes", periodeMap);
		mv.addObject("bulletinSalaire", new BulletinSalaire());
		mv.setViewName("bulletins/creerBulletin");

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public ModelAndView saveEmploye(@ModelAttribute("bulletinSalaire") BulletinSalaire bSalaire) {
		ModelAndView mv = new ModelAndView();
		bSalaire.setDateTime(LocalDateTime.now());
		bulletinSalaireRepository.save(bSalaire);

		mv.setViewName("redirect:lister");

		return mv;

	}

	@Transactional
	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView lister() {
		ModelAndView mv = new ModelAndView();

		List<BulletinSalaire> bulletins = bulletinSalaireRepository.findAll();
		Map<BulletinSalaire, ResultatCalculRemuneration> bulletinMap = new HashMap<>();
		for (BulletinSalaire bul : bulletins) {
			bulletinMap.put(bul, calculerRemunerationServiceSimple.calculer(bul));

		}

		mv.addObject("bulletins", bulletinMap);

		mv.setViewName("bulletins/listerBulletin");

		return mv;

	}

}
