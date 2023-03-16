package com.prueba.pichincha.repository;

import com.prueba.pichincha.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long> {

    Optional<Person> findByName(String name);

}
