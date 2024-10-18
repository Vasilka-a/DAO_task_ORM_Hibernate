package com.example.dao_hibernate.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Persons {
    @EmbeddedId
    private PersonInfo personInfo;

    @Column(nullable = false)
    private String phone_number;

    @Column(nullable = false)
    private String city_of_living;
}
