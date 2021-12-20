import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Main {

    static final String INSERT_INTO_PERSON = "insert into person (first_name, second_name) values (?, ?)";
    static final String SELECT_FROM_PERSON = "select * from person";

    public static void main(String... args) {
        try (final var context = new AnnotationConfigApplicationContext(MyConfiguration.class)) {
            var jdbcTemplate = context.getBean(JdbcTemplate.class);

            jdbcTemplate.update(INSERT_INTO_PERSON, "Donald", "Duck");
            jdbcTemplate.update(INSERT_INTO_PERSON, "Mickey", "Mouse");

            var list = jdbcTemplate.queryForList(SELECT_FROM_PERSON);
            System.out.println(list);
        }
    }
}
