package lesson;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebConfig implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {
//        creation of context
        AnnotationConfigWebApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigWebApplicationContext();
//        creation lesson.AppConfig bean for scanning another beans
        annotationConfigApplicationContext.register(AppConfig.class);
//        creation of servlet and sending app context into dispatcher servlet constructor
        DispatcherServlet dispatcherServlet = new DispatcherServlet(annotationConfigApplicationContext);
//        registration servlet in context
        ServletRegistration.Dynamic servletRegistration =
                servletContext.addServlet("dispatcher", dispatcherServlet);
//        registration servlet on startup application
        servletRegistration.setLoadOnStartup(1);
//        where will be our servlet
        servletRegistration.addMapping("/app/*");
    }
}
