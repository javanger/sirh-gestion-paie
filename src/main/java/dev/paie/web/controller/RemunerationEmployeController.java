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
import dev.paie.service.EntrepriseService;
import dev.paie.service.GradeService;
import dev.paie.service.ProfilService;
import dev.paie.service.RemunerationEmployeService;

/**
 * @author Axel B.
 *
 */
@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {

	@Autowired
	private EntrepriseService entrepriseS;
	@Autowired
	private ProfilService profilS;
	@Autowired
	private GradeService gradeS;

	@Autowired
	private RemunerationEmployeService remunerationEmployeS;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");

		mv.addObject("entreprises", entrepriseS.list());
		mv.addObject("profils", profilS.list());
		mv.addObject("grades", gradeS.list());
		mv.addObject("remunerationEmploye", new RemunerationEmploye());

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public ModelAndView submitForm(@ModelAttribute("remunerationEmploye") RemunerationEmploye remunerationEmploye) {
		ModelAndView mv = new ModelAndView();
		remunerationEmployeS.save(remunerationEmploye);

		mv.setViewName("redirect:lister");
		return mv;

	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView lister() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listerEmploye");

		mv.addObject("remunerationEmployes", remunerationEmployeS.list());
		return mv;
	}

}
