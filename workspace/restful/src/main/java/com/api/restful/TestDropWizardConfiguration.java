package com.api.restful;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;

import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

public class TestDropWizardConfiguration extends Configuration {
	@JsonProperty("swagger")
    public SwaggerBundleConfiguration swaggerBundleConfiguration;
}
