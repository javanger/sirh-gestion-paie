package dev.paie.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.Grade;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;

@Controller
@RequestMapping("/employes")

public class RemunerationEmployeController {

	@Autowired
	private EntrepriseRepository entrepriseRepo;
	@Autowired
	private ProfilRemunerationRepository profilRemu;

	@Autowired
	private GradeRepository gradeRepo;


	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {
		
		Map<Grade, String>salaires= new HashMap<>();
		for(Grade g : gradeRepo.findAll()){
			salaires.put(g, g.calculerSalaire());
		}
		
		

		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		// mv.addObject("prefixMatricule", "M00");
		mv.addObject("employe", new RemunerationEmploye());
		mv.addObject("entreprises", entrepriseRepo.findAll());
		mv.addObject("profils", profilRemu.findAll());
		mv.addObject("grades", salaires);
		

		return mv;
	}


	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listerEmploye");

		return mv;
	}
}