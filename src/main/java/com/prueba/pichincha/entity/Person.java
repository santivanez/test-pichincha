package com.prueba.pichincha.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERSON_ID")
    private Long personId;

    private String name;

    private String gender;

    private Integer age;

    private String identification;

    private String address;

    private String phone;

    @OneToOne(mappedBy = "personId")
    private Client client;

}
