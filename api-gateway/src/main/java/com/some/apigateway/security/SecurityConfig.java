package com.some.apigateway.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
            .authorizeExchange(authorizeExchangeSpec ->
                authorizeExchangeSpec
                    .pathMatchers("/api/resource/**").authenticated()
                    .anyExchange().authenticated()
            ).oauth2Login(Customizer.withDefaults());

        return http.build();
    }
}
