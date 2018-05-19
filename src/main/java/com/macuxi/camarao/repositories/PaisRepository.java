package com.macuxi.camarao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macuxi.camarao.domain.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer> {
	

}
