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
 * @author ETY0004
 *
 */
@Configuration
public class DataSourceH2Config {

	/**
	 * Connection a une base embarqué H2
	 * 
	 * @return
	 */
	@Bean
	public DataSource datasource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("schema.sql").build();
	}

}
