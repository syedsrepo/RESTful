package com.api.restful;

import com.api.restful.resources.ProfileResource;

import io.dropwizard.Application;


import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

public class TestDropWizardApplication extends Application<TestDropWizardConfiguration> {

    public static void main(final String[] args) throws Exception {
        new TestDropWizardApplication().run(args);
    }

    @Override
    public String getName() {
        return "TestDropWizard";
    }

    @Override
    public void initialize(final Bootstrap<TestDropWizardConfiguration> bootstrap) {
    	bootstrap.addBundle(new SwaggerBundle<TestDropWizardConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(TestDropWizardConfiguration configuration) {
                return configuration.swaggerBundleConfiguration;
            }
        });
    }

    @Override
    public void run(final TestDropWizardConfiguration configuration,
                    final Environment environment) {
    	ProfileResource resource = new ProfileResource();
    	environment.jersey().register(resource);
    }

}
