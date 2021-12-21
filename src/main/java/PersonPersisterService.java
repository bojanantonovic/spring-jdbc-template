import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PersonPersisterService {
	private static final String INSERT_INTO_PERSON = "insert into person (first_name, second_name) values (?, ?)";
	private static final String SELECT_FROM_PERSON = "select * from person";

	public void insertPerson(final String firstName, final String lastName, final JdbcTemplate jdbcTemplate) {
		jdbcTemplate.update(INSERT_INTO_PERSON, firstName, lastName);
	}

	public List<Map<String, Object>> seleteAllFromPerson(final JdbcTemplate jdbcTemplate) {
		return jdbcTemplate.queryForList(SELECT_FROM_PERSON);
	}
}
