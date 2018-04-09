/**
 * 
 */
package dev.paie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Kevin M.
 *
 */
@Configuration
@ComponentScan({ "dev.paie.services", "dev.paie.utils" })
@Import({ DataSourceH2Config.class, JpaConfig.class, JeuxDeDonneesConfig.class })
@EnableJpaRepositories("dev.paie.repositories")
public class ServicesConfig {

	// le bean passwordEncoder contient l’algorithme de hashage des mots de passe de
	// l’application
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
