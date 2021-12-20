import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("sql-server-properties.properties")
class SqlServerConfiguration extends AbstractDatabaseConfiguration {

}
