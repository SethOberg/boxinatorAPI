package com.project.boxinator.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig  {

//    @Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}")
//    private String jwkSetUri;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors().and()
                // Sessions will not be used
                .sessionManagement().disable()
                // Disable CSRF -- not necessary when there are no sessions
                .csrf().disable()
                // Enable security for http requests
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/v1/resources/public").permitAll()
                        .requestMatchers("/api/v1/resources/protected").hasAuthority("SCOPE_profile")
                        // All endpoints are protected
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer()
                .jwt();
        return http.build();
    }

//    @Bean
//    public JwtDecoder jwtDecoder() {
//        return NimbusJwtDecoder.withJwkSetUri(jwkSetUri).jwsAlgorithm(SignatureAlgorithm.RS512).build();
//    }
}
