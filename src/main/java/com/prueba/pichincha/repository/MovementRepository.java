package com.prueba.pichincha.repository;

import com.prueba.pichincha.entity.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<Movement, Long> {

}
