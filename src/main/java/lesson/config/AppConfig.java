package lesson.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(value = "lesson")
@EnableWebMvc
@Import({WebSecurity.class})
public class AppConfig {

}
