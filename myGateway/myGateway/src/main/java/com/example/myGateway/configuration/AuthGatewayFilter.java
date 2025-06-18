package com.example.myGateway.configuration;

import java.util.Random;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class AuthGatewayFilter extends AbstractGatewayFilterFactory<AuthGatewayFilter.Config> {

    public AuthGatewayFilter() {
        super(Config.class);
    }

    public static class Config {
        // Put configuration properties here if needed
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            // Pre-processing logic
        	System.out.println("Custom filter pre-processing");
        	Random random = new Random();
            int rand = random.nextInt(10);

           // We can Use our Auth here from Auth Service

            if (rand % 2 == 0) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }

            // Proceed in chain
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                // Post-processing logic (if needed)
                System.out.println("Custom filter post-processing");
            }));
        };
    }
}