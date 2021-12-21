import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

@SpringJUnitConfig(H2Configuration.class)
@Transactional // remove this if you want the table PERSON to be persistent on your database
class H2WithPersonPersisterServiceTest {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private PersonPersisterService personPersister;

	@Test
	@Sql("/init-h2.sql")
	void insertValues() {
		// act
		personPersister.insertPerson("Donald", "Duck", jdbcTemplate);
		personPersister.insertPerson("Mickey", "Mouse", jdbcTemplate);

		// assert
		var list = personPersister.seleteAllFromPerson(jdbcTemplate);
		System.out.println(list);
		Assertions.assertEquals(2, list.size());
	}
}
