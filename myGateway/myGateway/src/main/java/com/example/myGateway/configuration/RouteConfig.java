package com.example.myGateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {
	
	@Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("service-a", r -> r.path("/service-a/**")
                        .uri("http://localhost:49031")
                )
                .route("service-b", r -> r.path("/service-b/**")
                        .uri("http://localhost:49032")
                )
                .build();
    }

}
