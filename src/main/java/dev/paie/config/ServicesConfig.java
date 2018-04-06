/**
 * 
 */
package dev.paie.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Kevin M.
 *
 */
@Configuration
@ComponentScan({ "dev.paie.services", "dev.paie.utils" })
@Import({ DataSourceH2Config.class, JpaConfig.class, JeuxDeDonneesConfig.class })
@EnableJpaRepositories("dev.paie.repositories")
public class ServicesConfig {

}
