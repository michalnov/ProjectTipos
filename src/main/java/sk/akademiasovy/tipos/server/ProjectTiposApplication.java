package sk.akademiasovy.tipos.server;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

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
    }

}
