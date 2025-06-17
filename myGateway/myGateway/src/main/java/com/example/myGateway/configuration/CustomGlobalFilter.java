package com.example.myGateway.configuration;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class CustomGlobalFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // ✅ Pre-processing: Log request headers
        System.out.println("GlobalFilter - Pre-processing");
        System.out.println("Request URI: " + exchange.getRequest().getURI());
        
        return chain.filter(exchange).then(
            Mono.fromRunnable(() -> {
                // ✅ Post-processing: Log response headers and status
                System.out.println("GlobalFilter - Post-processing");
                System.out.println("Response Status Code: " + exchange.getResponse().getStatusCode());
            })
        );
    }

}
