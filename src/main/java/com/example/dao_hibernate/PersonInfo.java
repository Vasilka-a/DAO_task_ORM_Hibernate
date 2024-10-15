package com.example.dao_hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Data
@Builder
public class PersonInfo implements java.io.Serializable {
    @Column(name = "fullname")
    private String name;

    private String surname;

    private int age;

}
