package com.example.dao_hibernate;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class Controller {

    private Repository repository;

    @GetMapping("/persons/by-city")
    public List<Persons> getAllByCity(@RequestParam String city) {
        return repository.getPersonsByCity(city);
    }
}
