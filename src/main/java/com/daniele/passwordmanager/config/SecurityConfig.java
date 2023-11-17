package com.daniele.passwordmanager.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import java.net.http.HttpRequest;

@Configuration
@EnableWebSecurity
@PropertySource("classpath:application.properties")
public class SecurityConfig {

    @Value("${password-manager-base-url}")
    String baseUrl;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configurer->
                configurer
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .anyRequest().authenticated()
        )
                .formLogin(form ->
                        form
                                .loginPage(baseUrl+"/login-page")
                                .loginProcessingUrl(baseUrl+"/authenticateUser")
                                .permitAll()
                )
                .logout(LogoutConfigurer::permitAll
                );
        return httpSecurity.build();
    }
}
