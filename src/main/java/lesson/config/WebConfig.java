package lesson.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver internalResourceViewResolver =
                new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/pages/");
        internalResourceViewResolver.setSuffix(".jsp");
        registry.viewResolver(internalResourceViewResolver);
    }
}
