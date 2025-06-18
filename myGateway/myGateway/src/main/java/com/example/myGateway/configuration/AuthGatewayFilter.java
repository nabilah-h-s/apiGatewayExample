package com.example.myGateway.configuration;

import java.util.Objects;
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
    	private String debugMode;
        public String getDebugMode() { return debugMode; }
        public void setDebugMode(String debugMode) { this.debugMode = debugMode; }
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            // Pre-processing logic
        	System.out.println("Custom filter pre-processing");
        	Random random = new Random();
            int rand = random.nextInt(10);
            // System.out.println(config.getDebugMode());
            if(Objects.equals(config.getDebugMode(), "Enabled")) {
            	System.out.println("Random number "+rand);
            }
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