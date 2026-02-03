package com.empresa.viagens.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Spring Security configuration for the Viagens application.
 *
 * <p>Enables basic authentication and authorizes API endpoints. All endpoints are publicly
 * accessible for development purposes. In production, implement proper JWT or OAuth2
 * authentication.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

  /** Configure HTTP security for the application. */
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(
            authz ->
                authz
                    .requestMatchers("/", "/swagger-ui/**", "/v3/api-docs/**", "/actuator/**")
                    .permitAll()
                    .requestMatchers("/api/public/**")
                    .permitAll()
                    .requestMatchers("/api/auth/**")
                    .permitAll()
                    .anyRequest()
                    .permitAll() // For development: allow all. In production: use authenticated()
            )
        .csrf()
        .disable()
        .httpBasic();

    return http.build();
  }

  /** BCrypt password encoder for user password hashing. */
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
