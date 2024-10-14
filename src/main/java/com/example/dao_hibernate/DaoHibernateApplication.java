package com.example.dao_hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DaoHibernateApplication implements CommandLineRunner {
    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    @Override
    public void run(String... args) throws Exception {
        List<Persons> persons = new ArrayList<>();
        persons.add(Persons.builder().personInfo(PersonInfo.builder().name("Anna").surname("Ivanova").age(24).build())
                .phone_number("89276802556").city_of_living("Moscow").build());
        persons.add(Persons.builder().personInfo(PersonInfo.builder().name("Oleg").surname("Smirnov").age(45).build())
                .phone_number("89095688774").city_of_living("Kazan").build());
        persons.add(Persons.builder().personInfo(PersonInfo.builder().name("Petr").surname("Dozhdikov").age(32).build())
                .phone_number("89025647888").city_of_living("Moscow").build());
        persons.add(Persons.builder().personInfo(PersonInfo.builder().name("Anna").surname("Soboleva").age(29).build())
                .phone_number("89875630223").city_of_living("Samara").build());
        persons.add(Persons.builder().personInfo(PersonInfo.builder().name("Olga").surname("Orlova").age(56).build())
                .phone_number("89841450245").city_of_living("Kazan").build());

        persons.forEach(entityManager::persist);
    }

    public static void main(String[] args) {
        SpringApplication.run(DaoHibernateApplication.class, args);
    }

}
