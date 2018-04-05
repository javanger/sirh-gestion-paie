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

import dev.paie.entite.RemunerationEmploye;
import dev.paie.service.EntrepriseServiceDataJpa;
import dev.paie.service.GradeServiceDataJpa;
import dev.paie.service.ProfilServiceDataJpa;
import dev.paie.service.RemunerationEmployeServiceJpa;

/**
 * @author Alexis Darcy
 *
 */
@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {

	@Autowired
	private EntrepriseServiceDataJpa entrepriseServiceDataJpa;

	@Autowired
	private GradeServiceDataJpa gradeServiceDataJpa;

	@Autowired
	private ProfilServiceDataJpa profilServiceDataJpa;

	@Autowired
	private RemunerationEmployeServiceJpa remunerationEmployeServiceJpa;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		mv.addObject("entreprises", entrepriseServiceDataJpa.lister());
		mv.addObject("grades", gradeServiceDataJpa.lister());
		mv.addObject("profils", profilServiceDataJpa.lister());
		mv.addObject("remunerationEmploye", new RemunerationEmploye());
		return mv;
	}


	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public ModelAndView ajouterEmploye(@ModelAttribute("remunerationEmploye") RemunerationEmploye remunerationEmploye) {
		remunerationEmployeServiceJpa.sauvegarder(remunerationEmploye);
		return listerEmploye();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listerEmploye");
		mv.addObject("employes", remunerationEmployeServiceJpa.lister());
		return mv;
	}
}