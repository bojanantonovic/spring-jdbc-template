import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(H2Configuration.class)
class H2IntegrationTest {

	static final String INSERT_INTO_PERSON = "insert into person (first_name, second_name) values (?, ?)";
	static final String SELECT_FROM_PERSON = "select * from person";
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@BeforeEach
	void createTable() {
		jdbcTemplate.execute("create table person" + //
				"(" + //
				"first_name  varchar(100)," + //
				"second_name varchar(100)" + //
				")" //
		);
	}

	@Test
	void insertValues() {
		// act
		jdbcTemplate.update(INSERT_INTO_PERSON, "Donald", "Duck");
		jdbcTemplate.update(INSERT_INTO_PERSON, "Mickey", "Mouse");

		// assert
		var list = jdbcTemplate.queryForList(SELECT_FROM_PERSON);
		System.out.println(list);
		Assertions.assertEquals(2, list.size());
	}
}