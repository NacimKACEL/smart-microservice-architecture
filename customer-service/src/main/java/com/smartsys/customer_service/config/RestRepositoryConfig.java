package com.smartsys.customer_service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.smartsys.customer_service.entities.Customer;

@Configuration
public class RestRepositoryConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(
        RepositoryRestConfiguration repositoryRestConfiguration, CorsRegistry corsRegistry) {
            repositoryRestConfiguration.exposeIdsFor(Customer.class); 
    }

}
