/**
 * 
 */
package dev.paie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import dev.paie.util.PaieUtils;

/**
 * @author Emmanuel
 *
 */
@Configuration
@ComponentScan({"dev.paie.service","dev.paie.util"})
public class ServicesConfig {
	
	@Bean
	public PaieUtils paieUtils() { return new PaieUtils();}
	
}
