package com.prueba.pichincha.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "CLIENT_ID", nullable = false)
    private Long clientId;

    private String password;

    @JsonProperty
    private Boolean status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "PERSON_ID")
    private Person personId;

    @OneToMany(mappedBy = "client")
    private List<Account> accounts;

    @Builder(builderMethodName = "clientBuilder")
    public Client(String password, Boolean status){
        super();
        this.password = password;
        this.status = status;
    }

}
