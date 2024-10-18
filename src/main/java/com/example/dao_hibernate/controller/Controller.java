package com.example.dao_hibernate.controller;

import com.example.dao_hibernate.domain.Persons;
import com.example.dao_hibernate.repository.Repository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class Controller {
    private final Repository repository;

    @PostMapping("/persons")
    public Persons createPerson(@RequestBody Persons persons) {
        return repository.save(persons);
    }

    @GetMapping("/persons/by-city")
    public List<Persons> getAllByCity(@RequestParam String city) {
        return repository.findByCity(city);
    }

    @GetMapping("/persons/by-age")
    public List<Persons> getAllByAge(@RequestParam int age) {
        return repository.findByAge(age);
    }

    @GetMapping("/persons/by-name-surname")
    public Optional<Persons> getPersonByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return repository.findByNameAndSurname(name, surname);
    }

    @DeleteMapping("/persons/delete-person")
    public void deletePerson(@RequestBody Persons persons) {
        repository.delete(persons);
    }
}
