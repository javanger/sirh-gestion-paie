/**
 * 
 */
package dev.paie.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Alexis Darcy
 *
 */
@Controller
@RequestMapping("/connexion")
public class ConnexionController {

	@GetMapping
	public String afficherPageCreer() {
		return "connexion";
	}
}
