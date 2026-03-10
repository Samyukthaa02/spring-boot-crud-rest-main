package br.com.example.davidarchanjo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
            );
            // Add other security configurations like authorization rules if needed
            // For example:
            // .authorizeHttpRequests(authorize -> authorize
            //     .requestMatchers("/api/**").authenticated()
            //     .anyRequest().permitAll()
            // )
            // .formLogin(withDefaults()); // Enable form login if needed

        return http.build();
    }
}
