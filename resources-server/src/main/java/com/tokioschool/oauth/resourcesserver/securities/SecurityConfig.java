package com.tokioschool.oauth.resourcesserver.securities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChainMainly(HttpSecurity httpSecurity) throws Exception {
        // Define a security chain
        return httpSecurity
                .securityMatcher("/**")
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET,"/api/**").hasAnyAuthority("SCOPE_read","SCOPE_write")
                        .requestMatchers(HttpMethod.POST,"/api/**").hasAuthority("SCOPE_write")
                        .anyRequest().authenticated())
                // Disable CSRF as no forms are generated
                .csrf(AbstractHttpConfigurer::disable)
                // Default CORS configuration to allow requests from localhost
                .cors(Customizer.withDefaults())
                // Basic authentication
                //.httpBasic(Customizer.withDefaults())
                // JWT validation (decoder)
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
                // Disable Spring's form login
                .build();
    }
}
