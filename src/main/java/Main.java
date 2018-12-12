import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;
import java.util.Map;

public class Main {

    static final String DRIVER_CLASS_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static final String INSERT_INTO_PERSON = "insert into person (first_name, second_name) values (?, ?)";
    static final String SELECT_FROM_PERSON = "select * from person";

    public static void main(String... args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DRIVER_CLASS_NAME);
        dataSource.setUrl("jdbc:sqlserver://localhost");
        dataSource.setUsername("SA");
        dataSource.setPassword("Bojan123");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(INSERT_INTO_PERSON, "Donald", "Duck");
        jdbcTemplate.update(INSERT_INTO_PERSON, "Mickey", "Mouse");

        final List<Map<String, Object>> list = jdbcTemplate.queryForList(SELECT_FROM_PERSON);
        System.out.println(list);
    }

}
