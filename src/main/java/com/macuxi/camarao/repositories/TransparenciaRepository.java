package com.macuxi.camarao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.macuxi.camarao.domain.Transparencia;

@Repository
public interface TransparenciaRepository extends JpaRepository<Transparencia, Integer> {

	@Transactional(readOnly=true)	
	Transparencia findFirstByOrderByIdDesc();
}