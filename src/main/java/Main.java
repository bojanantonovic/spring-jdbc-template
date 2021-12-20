import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Main {

    static final String DRIVER_CLASS_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static final String INSERT_INTO_PERSON = "insert into person (first_name, second_name) values (?, ?)";
    static final String SELECT_FROM_PERSON = "select * from person";

    public static void main(String... args) {
        var dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DRIVER_CLASS_NAME);
        dataSource.setUrl("jdbc:sqlserver://localhost");
        dataSource.setUsername("SA");
        dataSource.setPassword("MyPass@word");

        var jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(INSERT_INTO_PERSON, "Donald", "Duck");
        jdbcTemplate.update(INSERT_INTO_PERSON, "Mickey", "Mouse");

        var list = jdbcTemplate.queryForList(SELECT_FROM_PERSON);
        System.out.println(list);
    }

}
