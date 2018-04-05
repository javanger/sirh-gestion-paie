/**
 * 
 */
package dev.paie.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author Alexis Darcy
 *
 */
//Marque un bean de configuration Spring 
@Configuration 
// Import de la configuration XML dans une configuration Java 
@ImportResource("classpath:jdd-config.xml") 
public class JeuxDeDonneesConfig { 
	
}