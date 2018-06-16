package com.macuxi.camarao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.macuxi.camarao.domain.Transparencia;
import com.macuxi.camarao.repositories.TransparenciaRepository;

@Service
public class TransparenciaService {

	@Autowired
	TransparenciaRepository repo;

	public void generateTransparencia() {
		Transparencia transparencia = new Transparencia(null, (Math.random() * ((30 - 35) + 1) + 35));
		this.insert(transparencia);
	}

	public Transparencia insert(Transparencia obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

	public Transparencia findTransparencia() {
		Transparencia transparencia = repo.findFirstByOrderByIdDesc();
		return transparencia;
	}

	public Page<Transparencia> findPageable(Integer page) {
		PageRequest pageRequest = new PageRequest(page, 2400, Direction.valueOf("DESC"), "id");
		return repo.findAll(pageRequest);
	}

}
