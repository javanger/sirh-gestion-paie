package dev.paie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import dev.paie.util.PaieUtils;

/**
 * @author Emmanuel
 *
 */
@Configuration
@ComponentScan({ "dev.paie.service", "dev.paie.util" })
@Import({ JpaConfig.class, DataSourceH2Config.class, SecurityConfig.class })
@EnableJpaRepositories("dev.paie.repository")
public class ServicesConfig {

	@Bean
	public PaieUtils paieUtils() {
		return new PaieUtils();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
