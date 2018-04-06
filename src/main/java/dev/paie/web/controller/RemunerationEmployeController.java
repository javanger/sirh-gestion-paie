package dev.paie.web.controller;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.service.GradeService;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {
	@Autowired
	private EntrepriseRepository entrepriseRepository;

	@Autowired
	private ProfilRepository profilRepository;

	@Autowired
	private GradeRepository gradeRepository;

	@Autowired
	private RemunerationEmployeRepository remunerationRepository;

	@Autowired
	private GradeService grade;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");

		mv.addObject("entreprise", entrepriseRepository.findAll());
		mv.addObject("profil", profilRepository.findAll());
		grade.calculerSalaire();
		mv.addObject("grade", gradeRepository.findAll());
		mv.addObject("remunerationEmploye", new RemunerationEmploye());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public String submitForm(@ModelAttribute("remunerationEmploye") RemunerationEmploye remunerationEmploye) {
		remunerationEmploye.setDateCreation(ZonedDateTime.now());
		remunerationRepository.save(remunerationEmploye);
		return "redirect:/mvc/employes/lister";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listerEmploye");

		mv.addObject("employe", remunerationRepository.findAll());
		return mv;
	}
}