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
 * @author Axel B.
 *
 */
@Configuration
public class DataSourceMySQLConfig {
	
	/*@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.h2database");
		dataSource.setUrl("jdbc:mariadb://localhost:3036/sirh_paie");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}*/
	
	@Bean
	public DataSource datasource() {
	return new EmbeddedDatabaseBuilder()
	.setType(EmbeddedDatabaseType.H2)
	.addScript("Sirh_paie.sql")
	.build();
	}
}
