package com.ganeshgc.mobile_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    // This bean is responsible for encoding passwords using the BCrypt hashing algorithm
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) //Disables Cross-Site Request Forgery (CSRF) protection
                .authorizeHttpRequests(authorize -> authorize.requestMatchers(HttpMethod.GET,
                                "/api/v1/mobiles/**").permitAll()
                        // Allows all GET requests to "/v1/api/**" without authentication
                        .anyRequest().authenticated())
                // Requires authentication for any other request
                .httpBasic(Customizer.withDefaults());
              // Enables HTTP Basic authentication
             return http.build();
         }
        // This bean provides user details service which stores users and their roles in memory
        @Bean
        public UserDetailsService userDetailsService() {
            // Creates a user named "ganesh" with the role "USER" and encodes the password "ganesh"
            UserDetails ganeshgc = User.builder()
                    .username("ganeshgc")
                    .password(passwordEncoder().encode("ganesh@2052"))
                    .roles("USER")
                    .build();
            UserDetails emamagar = User.builder()
                    .username("emamagar")
                    .password(passwordEncoder().encode("ema@2053"))
                    .roles("ADMIN")
                    .build();
            return new InMemoryUserDetailsManager(ganeshgc, emamagar);
        }
}
