import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("h2-properties.properties")
class H2Configuration extends AbstractDatabaseConfiguration {

}
