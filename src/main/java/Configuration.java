import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("sql-server-properties.properties")
class MyConfiguration {

	@Value("${driver.class.name}")
	private String driverClassName;
	@Value("${url}")
	private String url;
	@Value("${jdbc.user.name}")
	private String userName;
	@Value("${password}")
	private String password;

	@Bean
	DriverManagerDataSource createDriverManagerDataSource() {
		var dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);

		return dataSource;
	}

	@Bean
	JdbcTemplate jdbcTemple(final DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
