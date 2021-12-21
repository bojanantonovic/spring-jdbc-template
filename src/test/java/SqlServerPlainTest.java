import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

@Disabled // GitHub doesn't have a SQL Server instance
@SpringJUnitConfig(SqlServerConfiguration.class)
@Transactional // remove this if you want the table PERSON to be persistent on your database
class SqlServerPlainTest {

	static final String INSERT_INTO_PERSON = "insert into person (first_name, second_name) values (?, ?)";
	static final String SELECT_FROM_PERSON = "select * from person";
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	@Sql("/init-sql-server.sql")
	void insertValues() {
		// act
		jdbcTemplate.update(INSERT_INTO_PERSON, "Donald", "Duck");
		jdbcTemplate.update(INSERT_INTO_PERSON, "Mickey", "Mouse");

		// assert
		var list = jdbcTemplate.queryForList(SELECT_FROM_PERSON);
		System.out.println(list);
		Assertions.assertTrue(list.size() >= 2);
	}
}
