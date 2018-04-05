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
 * @author GOBERT Guillaume
 *
 */
@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {

	@Autowired
	private EntrepriseService entrepriseServ;
	@Autowired
	private GradeService gradeServ;
	@Autowired
	private ProfilService profilServ;
	@Autowired
	private RemunerationEmployeService remunerationServ;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		mv.addObject("entreprises", entrepriseServ.list());
		mv.addObject("grades", gradeServ.salaireAnnuel());
		mv.addObject("profils", profilServ.list());
		mv.addObject("remunerationEmploye", new RemunerationEmploye());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public ModelAndView submitForm(@ModelAttribute("remunerationEmploye") RemunerationEmploye remunerationEmploye) {
		remunerationServ.save(remunerationEmploye);
		return listerEmploye();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listerEmploye");
		mv.addObject("remunerationEmployes", remunerationServ.list());
		return mv;
	}
}