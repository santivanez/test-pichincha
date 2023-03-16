package com.prueba.pichincha.repository;

import com.prueba.pichincha.entity.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Long> {

    @Query(value = "SELECT c FROM Client c where c.personId IN (SELECT p.personId FROM Person p where p.name = ?1) ")
    Optional<Client> findClientByPersonName(String name);

}
