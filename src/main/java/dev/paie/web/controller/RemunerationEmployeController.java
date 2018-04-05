/**
 * 
 */
package dev.paie.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.Entreprise;
import dev.paie.service.IEntrepriseService;

/**
 * @author Emmanuel
 *
 */
@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {
	
	@Autowired
	private IEntrepriseService entrepriseService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {
		ModelAndView mv = new ModelAndView();
		
		List<Entreprise> entreprises = entrepriseService.lister();
		
		mv.setViewName("employes/creerEmploye");
		mv.addObject("entreprises", entreprises);
		
		return mv;
	}
}
