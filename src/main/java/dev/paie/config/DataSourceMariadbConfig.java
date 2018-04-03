/**
 * 
 */
package dev.paie.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author Kevin M.
 *
 */
@Configuration
public class DataSourceMariadbConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sirh_paie");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}

}
