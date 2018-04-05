package dev.paie.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class InitialiserDonneesServiceDevTest {

	@Test
	public void test() {
		for (int i = 1; i <= 12; i++) {
			// créer 12 période de l'année courante
			LocalDate currentDate = LocalDate.now();
			int dernierJourDuMois = currentDate.withMonth(i).lengthOfMonth();
			int premierJourDuMois = 1;

			System.out.println(dernierJourDuMois + " " + premierJourDuMois);

			LocalDate debutDeLaPriode = currentDate.withMonth(i).withDayOfMonth(premierJourDuMois);
			LocalDate finDeLaPriode = currentDate.withMonth(i).withDayOfMonth(dernierJourDuMois);

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");
			String debutDeLaPriodeFormater = debutDeLaPriode.format(formatter);
			String finDeLaPriodeFormater = finDeLaPriode.format(formatter);
			
			System.out.println("Période " + i + ": " + debutDeLaPriodeFormater + " à " + finDeLaPriodeFormater);

		}
		assert true;
	}
}
