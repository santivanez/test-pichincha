package com.prueba.pichincha.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long movementId;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date date;

    private double value;

    private double balance;

}
