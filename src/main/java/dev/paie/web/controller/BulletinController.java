/**
 * 
 */
package dev.paie.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entites.BulletinSalaire;
import dev.paie.entites.Periode;
import dev.paie.repositories.BulletinRepository;
import dev.paie.repositories.PeriodeRepository;
import dev.paie.repositories.RemunerationEmployeRepository;
import dev.paie.utils.PaieUtils;

/**
 * @author Kevin M.
 *
 */
@Controller
@RequestMapping("/bulletins")
public class BulletinController {

	@Autowired
	private BulletinRepository bRepo;
	@Autowired
	private RemunerationEmployeRepository rRepo;
	@Autowired
	private PeriodeRepository peRepo;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creer(Model model) {
		BulletinSalaire bulletin = new BulletinSalaire();

		List<Periode> periodes = peRepo.findAll();
		Map<Integer, String> periodesMap = new HashMap<>();

		if (periodes != null && !periodes.isEmpty()) {
			for (Periode p : periodes) {
				String dateDebut = PaieUtils.formatDate(p.getDateDebut());
				String dateFin = PaieUtils.formatDate(p.getDateFin());
				String periodeFormate = "de " + dateDebut + " à " + dateFin;
				periodesMap.put(p.getId(), periodeFormate);
			}
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("bulletin", bulletin);
		mv.addObject("employes", rRepo.findAll());
		mv.addObject("periodes", periodesMap);
		mv.setViewName("bulletins/creer");

		return mv;
	}

	// autre facon de faire
	public String creer2(Model model) {
		BulletinSalaire bulletin = new BulletinSalaire();

		List<Periode> periodes = peRepo.findAll();
		Map<Integer, String> periodesMap = new HashMap<>();

		if (periodes != null && !periodes.isEmpty()) {
			for (Periode p : periodes) {
				String dateDebut = PaieUtils.formatDate(p.getDateDebut());
				String dateFin = PaieUtils.formatDate(p.getDateFin());
				String periodeFormate = "de " + dateDebut + " à " + dateFin;
				periodesMap.put(p.getId(), periodeFormate);
			}
		}

		model.addAttribute("bulletin", bulletin);
		model.addAttribute("profils", rRepo.findAll());
		model.addAttribute("periodes", periodesMap);

		return "bulletins/creer";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public ModelAndView post(@ModelAttribute("bulletin") BulletinSalaire bulletin) {
		bRepo.save(bulletin);
		return new ModelAndView("redirect:lister");
	}

	@RequestMapping(method = RequestMethod.GET, path = { "", "/", "/lister" })
	public ModelAndView lister() {
		ModelAndView mv = new ModelAndView("bulletins/lister");
		return mv;
	}

}
