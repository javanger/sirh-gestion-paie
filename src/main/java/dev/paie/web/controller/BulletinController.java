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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entites.BulletinSalaire;
import dev.paie.entites.Periode;
import dev.paie.repositories.BulletinRepository;
import dev.paie.repositories.PeriodeRepository;
import dev.paie.repositories.ProfilRemunerationRepository;
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
	private ProfilRemunerationRepository pRepo;
	@Autowired
	private PeriodeRepository peRepo;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creer(Model model) {
		BulletinSalaire bulletin = new BulletinSalaire();

		List<Periode> periodes = peRepo.findAll();
		Map<Integer, String> periodesMap = new HashMap<>();

		if (periodes != null && periodes.isEmpty()) {
			for (Periode p : periodes) {
				String dateDebut = PaieUtils.formatDate(p.getDateDebut());
				String dateFin = PaieUtils.formatDate(p.getDateFin());
				String periodeFormate = "de " + dateDebut + " à " + dateFin;
				periodesMap.put(p.getId(), periodeFormate);
			}
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("bulletin", bulletin);
		mv.addObject("profils", pRepo.findAll());
		mv.addObject("perioides", periodesMap);
		mv.setViewName("bulletins/creer");

		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, path = { "", "/" })
	public String lister() {
		return "bulletins/lister";
	}

}
