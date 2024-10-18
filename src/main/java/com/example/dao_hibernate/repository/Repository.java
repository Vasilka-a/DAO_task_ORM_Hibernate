package com.example.dao_hibernate.repository;

import com.example.dao_hibernate.domain.PersonInfo;
import com.example.dao_hibernate.domain.Persons;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Persons, PersonInfo> {
    List<Persons> findPersonsByCity(String city);

    List<Persons> findPersonsByPersonInfoAgeLessThan(Integer age, Sort sort);

    Optional<Persons> findByPersonInfoNameAndPersonInfoSurname(String name, String surname);
}
