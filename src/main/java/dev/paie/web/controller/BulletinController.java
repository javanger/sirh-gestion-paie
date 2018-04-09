/**
 * 
 */
package dev.paie.web.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entites.BulletinSalaire;
import dev.paie.entites.Periode;
import dev.paie.repositories.BulletinRepository;
import dev.paie.repositories.PeriodeRepository;
import dev.paie.repositories.RemunerationEmployeRepository;
import dev.paie.services.CalculerRemunerationService;
import dev.paie.services.model.BulletinDetailleServiceModel;
import dev.paie.services.model.ResultatCalculRemunerationServiceModel;
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
	@Autowired
	private PaieUtils paieUtils;
	@Autowired
	private CalculerRemunerationService calculateur;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView creer(Model model) {
		BulletinSalaire bulletin = new BulletinSalaire();

		List<Periode> periodes = peRepo.findAll();
		Map<Integer, String> periodesMap = new HashMap<>();

		if (periodes != null && !periodes.isEmpty()) {
			for (Periode p : periodes) {
				periodesMap.put(p.getId(), paieUtils.formatPeriode(p));
			}
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("bulletin", bulletin);
		mv.addObject("employes", rRepo.findAll());
		mv.addObject("periodes", periodesMap);
		mv.setViewName("bulletins/creer");

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView post(@ModelAttribute("bulletin") BulletinSalaire bulletin) {
		bulletin.setDateCreation(LocalDateTime.now());
		bRepo.save(bulletin);
		return new ModelAndView("redirect:lister");
	}

	@RequestMapping(method = RequestMethod.GET, path = { "", "/", "/lister" })
	@Secured({ "ROLE_ADMINISTRATEUR", "ROLE_UTILISATEUR" })
	@Transactional
	public ModelAndView lister() {

		List<BulletinDetailleServiceModel> bulletins = new ArrayList<>();

		for (BulletinSalaire b : bRepo.findAll()) {
			ResultatCalculRemunerationServiceModel result = calculateur.calculer(b);
			BulletinDetailleServiceModel bSemi = new BulletinDetailleServiceModel(b,
					paieUtils.formatDateTime(b.getDateCreation()), paieUtils.formatPeriode(b.getPeriode()), result);
			bulletins.add(bSemi);
		}

		ModelAndView mv = new ModelAndView("bulletins/lister", "bulletins", bulletins);
		return mv;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@Secured({ "ROLE_ADMINISTRATEUR", "ROLE_UTILISATEUR" })
	@Transactional
	public ModelAndView visualiser(@PathVariable Integer id) {
		BulletinSalaire bulletin = bRepo.findOne(id);
		String dateCreation = paieUtils.formatDateTime(bulletin.getDateCreation());
		String periode = paieUtils.formatPeriode(bulletin.getPeriode());
		BulletinDetailleServiceModel bComplet = new BulletinDetailleServiceModel(bulletin, dateCreation,
				periode,
				calculateur.calculer(bulletin));

		ModelAndView mv = new ModelAndView();
		mv.addObject("b", bComplet);
		mv.setViewName("bulletins/detailsBulletin");

		return mv;
	}
}
