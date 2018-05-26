package com.macuxi.camarao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macuxi.camarao.domain.Tanque;

@Repository
public interface TanqueRepository extends JpaRepository<Tanque, Integer> {

}
