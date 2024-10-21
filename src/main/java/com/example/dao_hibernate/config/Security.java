package com.example.dao_hibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class Security {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.withUsername("Alexey")
                .password(passwordEncoder().encode("ADMIN")).roles("ADMIN").build();

        UserDetails manager = User.withUsername("Anna")
                .password(passwordEncoder().encode("MANAGER")).roles("MANAGER").build();

        UserDetails hr = User.withUsername("Maria")
                .password(passwordEncoder().encode("RECRUITER")).roles("HR").build();

        return new InMemoryUserDetailsManager(admin, manager, hr);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((request) -> request
                .requestMatchers("/hello").permitAll()
                .requestMatchers("/persons/by-city").hasRole("HR")
                .requestMatchers("/persons/by-age").hasRole("HR")
                .requestMatchers("/persons/by-name-surname").hasRole("MANAGER")
                .requestMatchers("/persons/delete-person").hasRole("ADMIN")
                .anyRequest().authenticated()
        ).formLogin(withDefaults());
        return http.build();
    }
}
