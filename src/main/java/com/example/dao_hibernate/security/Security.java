package com.example.dao_hibernate.security;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity
public class Security  {
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.withUsername("Alexey")
                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
                .password("ADMIN").roles("ADMIN").build();

        UserDetails manager = User.withUsername("Anna")
                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
                .password("MANAGER").roles("MANAGER").build();

        UserDetails hr = User.withUsername("Maria")
                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
                .password("RECRUITER").roles("HR").build();

//        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
//
//        userDetailsManager.createUser(admin);
//        userDetailsManager.createUser(manager);
//        userDetailsManager.createUser(hr);

        return new InMemoryUserDetailsManager(admin, manager, hr);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/hello").permitAll()
                        .requestMatchers("/persons").hasAuthority("MANAGER")
                        .requestMatchers("/persons/by-city").hasAuthority("HR")
                        .requestMatchers("/persons/by-age").hasAuthority("HR")
                        .requestMatchers("/persons/by-name-surname").hasAuthority("HR")
                        .requestMatchers("/persons/delete-person").hasAuthority("ADMIN")
                        .anyRequest().authenticated()
                );
        return http.build();
    }
}
