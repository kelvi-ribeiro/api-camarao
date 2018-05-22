package com.macuxi.camarao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macuxi.camarao.domain.Tanque;
import com.macuxi.camarao.repositories.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository repo;
	
	public List<Tanque> findAll() {
		return repo.findAllByOrderByNome();
	}
}