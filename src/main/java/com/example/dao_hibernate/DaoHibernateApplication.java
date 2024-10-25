package com.example.dao_hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class DaoHibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(DaoHibernateApplication.class, args);
    }
}
