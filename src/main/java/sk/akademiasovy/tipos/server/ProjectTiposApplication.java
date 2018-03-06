package sk.akademiasovy.tipos.server;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import sk.akademiasovy.tipos.server.resources.Home;
import sk.akademiasovy.tipos.server.resources.Login;
import sk.akademiasovy.tipos.server.resources.MainPage;
import sk.akademiasovy.tipos.server.resources.WebSource;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

public class ProjectTiposApplication extends Application<ProjectTiposConfiguration> {

    public static void main(final String[] args) throws Exception {
        new ProjectTiposApplication().run(args);
    }

    @Override
    public String getName() {
        return "ProjectTipos";
    }

    @Override
    public void initialize(final Bootstrap<ProjectTiposConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final ProjectTiposConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        environment.jersey().register( new Login() );
        environment.jersey().register( new WebSource() );
        environment.jersey().register( new Home() );
        environment.jersey().register( new MainPage() );

        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);
        // Configure CORS parameters
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
    }

}
