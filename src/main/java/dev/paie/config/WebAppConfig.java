/**
 * 
 */
package dev.paie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author Kevin M.
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan({ "dev.paie.web.controller", "dev.paie.web.listener" })
@Import({ ServicesConfig.class, SecurityConfig.class })
public class WebAppConfig {

	@Bean
	public ViewResolver viewResolver() {
		// spécifier que j'utilise des jsp comme moteur de template
		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
	}
}
