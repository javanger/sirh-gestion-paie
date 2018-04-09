package dev.paie.web.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	@Autowired
	private GradeRepository gradeRepository;
	@Autowired
	private ProfilRemunerationRepository profilRemunerationRepository;
	@Autowired
	private RemunerationEmployeRepository remunerationEmployerRepository;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView creerEmploye() {
		ModelAndView mv = new ModelAndView();

		List<Entreprise> entreprises = entrepriseRepository.findAll();
		List<Grade> grades = gradeRepository.findAll();
		List<ProfilRemuneration> profilRemus = profilRemunerationRepository.findAll();

		mv.setViewName("employes/creerEmploye");
		mv.addObject("entreprises", entreprises);
		mv.addObject("grades", grades);
		mv.addObject("profils", profilRemus);
		mv.addObject("employee", new RemunerationEmploye());
		return mv;

	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView saveEmploye(@ModelAttribute("employee") RemunerationEmploye rEmploye) {
		ModelAndView mv = new ModelAndView();
		rEmploye.setDateTime(LocalDateTime.now());
		remunerationEmployerRepository.save(rEmploye);

		mv.setViewName("redirect:lister");

		return mv;

	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	@Secured({ "ROLE_UTILISATEUR", "ROLE_ADMINISTRATEUR" })
	public ModelAndView lister() {
		ModelAndView mv = new ModelAndView();

		List<RemunerationEmploye> remuEmp = remunerationEmployerRepository.findAll();
		mv.addObject("remuEmp", remuEmp);

		mv.setViewName("employes/listerEmploye");

		mv.addObject("remuEmp", remuEmp);

		return mv;

	}
}

// @RequestMapping(method = RequestMethod.GET, path = "/")
// public ModelAndView lister() {
//
//
// }
