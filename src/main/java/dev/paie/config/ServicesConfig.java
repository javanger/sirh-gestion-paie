/**
 * 
 */
package dev.paie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import dev.paie.util.PaieUtils;

/**
 * @author Emmanuel
 *
 */
@Configuration
@ComponentScan({ "dev.paie.service", "dev.paie.util" })
@Import({ JpaConfig.class, DataSourceH2Config.class })
@EnableJpaRepositories("dev.paie.repository")
public class ServicesConfig {

	@Bean
	public PaieUtils paieUtils() {
		return new PaieUtils();
	}

}
