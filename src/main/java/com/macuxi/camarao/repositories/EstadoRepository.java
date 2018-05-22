package com.macuxi.camarao.repositories;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.macuxi.camarao.domain.Tanque;

@Repository
public interface EstadoRepository extends JpaRepository<Tanque, Integer> {
	
	@Transactional(readOnly=true)
	public List<Tanque> findAllByOrderByNome();

}
