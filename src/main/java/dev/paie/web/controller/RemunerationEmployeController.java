package dev.paie.web.controller;

import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.Grade;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/employes")

public class RemunerationEmployeController {

	@Autowired
	private EntrepriseRepository entrepriseRepo;
	@Autowired
	private ProfilRemunerationRepository profilRemu;

	@Autowired
	private GradeRepository gradeRepo;
	@Autowired
	private RemunerationEmployeRepository employeRepository;


	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {
		// (g1, g2) -> g1.calculerSalaire().compareTo(g2.calculerSalaire())
		Map<Grade, String> salaires = new TreeMap<>(Comparator.comparing(Grade::calculerSalaire));

		gradeRepo.findAll().forEach(g -> {
			salaires.put(g, g.calculerSalaire());
		});
		
		

		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		// mv.addObject("prefixMatricule", "M00");
		mv.addObject("employe", new RemunerationEmploye());
		mv.addObject("entreprises", entrepriseRepo.findAll());
		mv.addObject("profils", profilRemu.findAll());
		mv.addObject("grades", salaires);
		

		return mv;
	}


	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public String submitForm(@ModelAttribute("employe") RemunerationEmploye remunerationEmploye) {
		remunerationEmploye.setDateCreation(ZonedDateTime.now());
		employeRepository.save(remunerationEmploye);
		
		return "redirect:/mvc/employes/lister";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listerEmploye");
		mv.addObject("employes", employeRepository.findAll());

		return mv;
	}
}