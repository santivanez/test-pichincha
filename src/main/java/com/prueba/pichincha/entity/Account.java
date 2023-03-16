package com.prueba.pichincha.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Account")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long accountId;

    @Column(name = "number_account")
    private String numberAccount;

    @Enumerated(EnumType.STRING)
    private Status type;

    private double initialBalance;

    private boolean status;

    @ManyToOne
    @JoinColumn(name="CLIENT_ID", nullable=false)
    private Client client;

}
