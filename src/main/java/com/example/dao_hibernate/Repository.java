package com.example.dao_hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@org.springframework.stereotype.Repository
@AllArgsConstructor
@NoArgsConstructor
public class Repository {
    @PersistenceContext
    EntityManager entityManager;

    public List<Persons> getPersonsByCity(String city) {
        return (List<Persons>) entityManager.createQuery(" select persons from Persons persons where city_of_living = :city")
                .setParameter("city", city)
                .getResultList();
    }


}
