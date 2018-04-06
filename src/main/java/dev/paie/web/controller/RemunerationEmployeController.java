/**
 * 
 */
package dev.paie.web.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entites.Entreprise;
import dev.paie.entites.Grade;
import dev.paie.entites.ProfilRemuneration;
import dev.paie.entites.RemunerationEmploye;
import dev.paie.repositories.EntrepriseRepository;
import dev.paie.repositories.GradeRepository;
import dev.paie.repositories.ProfilRemunerationRepository;
import dev.paie.repositories.RemunerationEmployeRepository;
import dev.paie.utils.Constantes;
import dev.paie.utils.PaieUtils;

/**
 * @author Kevin M.
 *
 */
@Controller
@RequestMapping("/remunerations")
public class RemunerationEmployeController {

	@Autowired
	private RemunerationEmployeRepository rRepo;
	@Autowired
	private EntrepriseRepository eRepo;
	@Autowired
	private GradeRepository gRepo;
	@Autowired
	private ProfilRemunerationRepository pRepo;
	@Autowired
	private PaieUtils paieUtils;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creer() {
		// récupérer la liste des entrprises
		List<Entreprise> entreprises = eRepo.findAll();
		List<Grade> grades = gRepo.findAll();
		Map<Grade, String> gradesEtCalculs = new HashMap<>();

		for (Grade grade : grades) {
			BigDecimal calcul = grade.getNbHeuresBase().multiply(grade.getTauxBase())
					.multiply(new BigDecimal(Constantes.NOMBRE_DE_MOIS_PAR_ANNEE));
			gradesEtCalculs.put(grade, paieUtils.arrondie(calcul));
		}

		List<ProfilRemuneration> profils = pRepo.findAll();

		ModelAndView mv = new ModelAndView();
		mv.setViewName("remunerations/creer");
		mv.addObject("entreprises", entreprises);
		mv.addObject("gradesEtCalculs", gradesEtCalculs);
		mv.addObject("profils", profils);
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = { "/creer" })
	public ModelAndView creerProcess(@RequestParam("inputMatricule") String matricule,
			@RequestParam("selectProfil") Integer idProfil, @RequestParam("selectEntreprise") Integer idEntreprise,
			@RequestParam("selectGrade") Integer idGrade) {

		RemunerationEmploye remuneration = new RemunerationEmploye();
		remuneration.setMatricule(matricule);
		remuneration.setEntreprise(eRepo.findOne(idEntreprise));
		remuneration.setGrade(gRepo.findOne(idGrade));
		remuneration.setProfilRemuneration(pRepo.findOne(idProfil));
		remuneration.setDateCreation(LocalDateTime.now());

		rRepo.save(remuneration);
		return new ModelAndView("redirect:lister");
	}

	@RequestMapping(method = RequestMethod.GET, path = { "", "/", "/lister" })
	public ModelAndView lister() {
		// récupérer la liste de remunerations

		List<RemunerationEmploye> remunerations = rRepo.findAll();
		Map<RemunerationEmploye, String> remuEtDate = new HashMap<>();
		for (RemunerationEmploye r : remunerations) {
			remuEtDate.put(r, paieUtils.formatDateTime(r.getDateCreation()));
		}

		ModelAndView mv = new ModelAndView();
		mv.addObject("map", remuEtDate);
		mv.setViewName("remunerations/lister");
		return mv;
	}
}
