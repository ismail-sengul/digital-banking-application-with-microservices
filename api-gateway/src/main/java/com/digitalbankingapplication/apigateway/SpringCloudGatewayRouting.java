package com.digitalbankingapplication.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudGatewayRouting {

    @Bean
    public RouteLocator configureRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                //http://localhost:8080/customer/XX
                //.route("accountId", r->r.path("/account/**").uri("http://localhost:9009")) //static routing
                .route("customerId", r->r.path("/api/v1/customers/**").uri("http://localhost:8762")) //static routing
                .build();
    }
}
