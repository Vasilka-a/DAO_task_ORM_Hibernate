package com.example.dao_hibernate.controller;

import com.example.dao_hibernate.domain.Persons;
import com.example.dao_hibernate.repository.Repository;
import jakarta.annotation.security.RolesAllowed;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class Controller {
    private final Repository repository;

    @GetMapping("/persons/by-city")
    @Secured("ROLE_READ")
    public List<Persons> getAllByCity(@RequestParam String city) {
        return repository.findPersonsByCity(city);
    }

    @GetMapping("/persons/by-age")
    @RolesAllowed("ROLE_WRITE")
    public List<Persons> getAllByAge(@RequestParam Integer age) {
        return repository.findPersonsByPersonInfoAgeLessThan(age, Sort.by("personInfoAge"));
    }

    @GetMapping("/persons/by-name-surname")
    @PreAuthorize("hasAnyRole('ROLE_DELETE','ROLE_WRITE')")
    public Optional<Persons> getPersonByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return repository.findByPersonInfoNameAndPersonInfoSurname(name, surname);
    }

    @GetMapping("/hello")
    @PreAuthorize("#username == authentication.principal.username")
    public String hello(String username) {
        return "Hello + " + username + " !";
    }
}
