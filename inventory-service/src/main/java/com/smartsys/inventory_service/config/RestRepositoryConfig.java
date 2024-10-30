package com.smartsys.inventory_service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.smartsys.inventory_service.entities.Product;

@Configuration
public class RestRepositoryConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(
        RepositoryRestConfiguration repositoryRestConfiguration, CorsRegistry corsRegistry) {
            repositoryRestConfiguration.exposeIdsFor(Product.class); 
    }

}
