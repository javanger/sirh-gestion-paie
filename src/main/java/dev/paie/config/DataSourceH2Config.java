/**
 * 
 */
package dev.paie.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * @author Alexis Darcy
 *
 */
@Configuration
public class DataSourceH2Config {

	/** céation base de données test
	 * @return DataSource : H2
	 */
	@Bean
	public DataSource dataSource() {
		
		return new EmbeddedDatabaseBuilder()   
		.setType(EmbeddedDatabaseType.H2)   
		.addScript("schema.sql")   
		.build(); 
		
	}
}