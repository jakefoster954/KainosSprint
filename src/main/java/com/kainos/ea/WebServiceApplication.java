package com.kainos.ea;

import com.kainos.ea.resources.WebService;
import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.sql.Connection;

public class WebServiceApplication extends Application<WebServiceConfiguration> {

    public static void main(final String[] args) throws Exception {
        new WebServiceApplication().run(args);

        Class driver = Class.forName("com.mysql.cj.jdbc.Driver");

        Connection c = DBConnector.getConnection();
    }

    @Override
    public String getName() {
        return "WebService";
    }

    @Override
    public void initialize(final Bootstrap<WebServiceConfiguration> bootstrap) {
        // TODO: application initialization
        // public void initialize(Bootstrap<MyConfiguration> bootstrap) {
        //        // Enable variable substitution with environment variables
        bootstrap.setConfigurationSourceProvider(
            new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
            new EnvironmentVariableSubstitutor(false))
        );
    }

    @Override
    public void run(final WebServiceConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(new WebService());
        // TODO: implement application
        getName();
    }

}
