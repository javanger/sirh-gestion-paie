/**
 * 
 */
package dev.paie.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Alexis Darcy
 *
 */
@Configuration 
@ComponentScan({"dev.paie.service","dev.paie.util"}) 
public class ServicesConfig {
	
}