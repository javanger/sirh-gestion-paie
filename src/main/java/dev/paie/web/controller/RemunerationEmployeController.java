package dev.paie.web.controller;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRepository;
import dev.paie.repository.RemunerationEmployeRepository;

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

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");

		mv.addObject("entreprise", entrepriseRepository.findAll());
		mv.addObject("profil", profilRepository.findAll());
		mv.addObject("grade", gradeRepository.findAll());
		mv.addObject("remunerationEmploye", new RemunerationEmploye());
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(Model model) {
		model.addAttribute("remunerationEmploye", new RemunerationEmploye());

		return "employes/creerEmploye";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public ModelAndView submitForm(@ModelAttribute("remunerationEmploye") RemunerationEmploye remunerationEmploye) {
		remunerationEmploye.setDateCreation(ZonedDateTime.now());
		remunerationRepository.save(remunerationEmploye);
		return listerEmploye();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listerEmploye");

		mv.addObject("employe", remunerationRepository.findAll());
		return mv;
	}
}