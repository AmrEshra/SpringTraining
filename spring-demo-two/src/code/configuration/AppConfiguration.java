package code.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("code")
@PropertySource("classpath:sport.properties")
public class AppConfiguration {

}
