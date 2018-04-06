/**
 * 
 */
package dev.paie.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.controller.viewmodel.CotisationViewModel;
import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.service.BulletinSalaireService;
import dev.paie.service.PeriodeService;
import dev.paie.service.RemunerationEmployeService;
import dev.paie.util.PaieUtils;

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

	@Autowired
	private PaieUtils paieUtils;

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
	public String ajouterEmploye(@ModelAttribute("bulletinSalaire") BulletinSalaire bulletinSalaire) {
		bulletinServiceDataJpa.sauvegarder(bulletinSalaire);
		return "redirect:/mvc/bulletins/lister";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/listerBulletin");
		mv.addObject("bulletinServices", bulletinServiceDataJpa.calcul());
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/visualiser/{id}")
	public ModelAndView visualiserEmploye(@PathVariable Integer id) {
		ModelAndView mv = new ModelAndView();
		BulletinSalaire bulletinSalaire = bulletinServiceDataJpa.recuperer(id);
		ResultatCalculRemuneration resultatCalculRemuneration = bulletinServiceDataJpa.calcul(id);
		List<CotisationViewModel> cotisationsNonImposables = bulletinSalaire.getRemunerationEmploye()
				.getProfilRemuneration().getCotisationsNonImposables().stream()
				.map(c -> {
					CotisationViewModel co = new CotisationViewModel(c, resultatCalculRemuneration, paieUtils);
					return co;
				}).collect(Collectors.toList());
		List<CotisationViewModel> cotisationsImposables = bulletinSalaire.getRemunerationEmploye()
				.getProfilRemuneration().getCotisationsImposables().stream().map(c -> {
					CotisationViewModel co = new CotisationViewModel(c, resultatCalculRemuneration, paieUtils);
			return co;
				}).collect(Collectors.toList());
		mv.setViewName("bulletins/visualiserBulletin");
		mv.addObject("bulletin", bulletinSalaire);
		mv.addObject("calcul", resultatCalculRemuneration);
		mv.addObject("cotisationsNonImposables", cotisationsNonImposables);
		mv.addObject("cotisationsImposables", cotisationsImposables);
		return mv;
	}
}