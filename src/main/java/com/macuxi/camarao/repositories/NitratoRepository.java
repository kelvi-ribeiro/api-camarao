package com.macuxi.camarao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.macuxi.camarao.domain.Nitrato;

@Repository
public interface NitratoRepository extends JpaRepository<Nitrato, Integer> {
	
	@Transactional(readOnly=true)	
	Nitrato findFirstByOrderByIdDesc();

}
