package com.example.dao_hibernate.repository;

import com.example.dao_hibernate.domain.PersonInfo;
import com.example.dao_hibernate.domain.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Persons, PersonInfo> {
    @Query("select p from Persons p where p.city_of_living = :city")
    List<Persons> findByCity(@Param("city") String city);

    @Query("select p from Persons p where p.personInfo.age < :age order by p.personInfo.age")
    List<Persons> findByAge(@Param("age") int age);

    @Query("select p from Persons p where p.personInfo.name = :name and p.personInfo.surname = :surname")
    Optional<Persons> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
}
