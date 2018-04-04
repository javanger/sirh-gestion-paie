/**
 * 
 */
package dev.paie.app;

import java.math.BigDecimal;
import java.util.Scanner;

import org.springframework.context.annotation.Import;

import dev.paie.config.ServicesConfig;
import dev.paie.entites.Cotisation;
import dev.paie.services.CotisationService;
import dev.paie.services.CotisationServiceJpa;

/**
 * @author Kevin M.
 *
 */
public class ConsoleApp {

	private static CotisationService cotisationJpaService;
	private static Scanner sc = new Scanner(System.in);

	/**
	 * @param args
	 *            : void
	 */
	public static void main(String[] args) {

		cotisationJpaService = new CotisationServiceJpa();
		String choix = "";
		do {
			System.out.println("** Gestion des cotisations **\n " + "1. Lister des cotisations\n"
					+ "2. Créer une cotisation\n" + "3. Supprimer une cotisation\n");
			choix = sc.nextLine();

			switch (choix) {
			case "1": {
				cotisationJpaService.lister().forEach(c -> {
					System.out.println(c.getId() + " " + c.getCode() + " " + c.getLibelle());
				});
				break;
			}
			case "2": {
				modifier();
				break;
			}
			case "3": {
				supprimer();
				break;
			}
			default:
				break;
			}
		} while (choix.equals("q") == false);

		System.out.println("A bientot :) ");
	}

	private static void supprimer() {
		System.out.println("Entrer l'id de la cotisation à supprimer:");
		Integer id = Integer.parseInt(sc.nextLine());
		Cotisation cotisation = cotisationJpaService.trouverParId(id);
		cotisationJpaService.supprimer(cotisation);
	}

	private static void modifier() {
		System.out.println("Entrer l'id de la cotisation à modifier:");
		Integer id = Integer.parseInt(sc.nextLine());
		System.out.println("Entrer le noveau code :");
		String code = sc.nextLine();
		System.out.println("Entrer le noveau libellé :");
		String libelle = sc.nextLine();
		System.out.println("Entrer le noveau taux patronal :");
		String tauxPatronal = sc.nextLine();
		System.out.println("Entrer le noveau taux salarial :");
		String tauxSalarial = sc.nextLine();

		Cotisation cot = cotisationJpaService.trouverParId(id);
		cot.setCode("CO02");
		cot.setLibelle("Coti 02");
		cot.setTauxPatronal(new BigDecimal("55.2"));
		cot.setTauxSalarial(new BigDecimal("20.25"));

		cotisationJpaService.mettreAjour(cot);
	}

}
