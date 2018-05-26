package com.macuxi.camarao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macuxi.camarao.domain.Arduino;

@Repository
public interface ArduinoRepository extends JpaRepository<Arduino, Integer> {

}
