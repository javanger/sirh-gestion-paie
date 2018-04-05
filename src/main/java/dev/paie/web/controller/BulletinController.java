/**
 * 
 */
package dev.paie.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Kevin M.
 *
 */
@Controller
@RequestMapping("/bulletins")
public class BulletinController {

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public String creer() {
		return "bulletins/creer";
	}

	@RequestMapping(method = RequestMethod.GET, path = { "", "/" })
	public String lister() {
		return "bulletins/lister";
	}

	/*
	 * @RequestMapping(method = RequestMethod.GET) public ModelAndView lister() {
	 * ModelAndView mv = new ModelAndView();
	 * mv.setViewName("employes/creerEmploye"); mv.addObject("prefixMatricule",
	 * "M00"); return mv; }
	 */
}
