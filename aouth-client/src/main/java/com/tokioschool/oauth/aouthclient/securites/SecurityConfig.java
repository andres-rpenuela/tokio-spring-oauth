package com.tokioschool.oauth.aouthclient.securites;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChainMainly(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests( oauthHttp ->
                        oauthHttp.requestMatchers(HttpMethod.GET,"/authorized").permitAll()
                                .anyRequest().authenticated()
                )
                // ...
                .oauth2Login( login -> login.loginPage("/oauth2/authorization/my-client"))
                // read properties oauth2
                .oauth2Client(Customizer.withDefaults())
                .build();
    }
}
