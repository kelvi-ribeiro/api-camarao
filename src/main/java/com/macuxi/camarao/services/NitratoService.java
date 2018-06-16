package com.macuxi.camarao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.macuxi.camarao.domain.Nitrato;
import com.macuxi.camarao.repositories.NitratoRepository;

@Service
public class NitratoService {

	@Autowired
	NitratoRepository repo;

	public void generateNitrato() {
		Nitrato nitrato = new Nitrato(null, (Math.random() * ((5.0 - 0.0) + 1) + 0.0));
		this.insert(nitrato);

	}

	public Nitrato insert(Nitrato obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

	public Nitrato findNitrato() {
		Nitrato nitrato = repo.findFirstByOrderByIdDesc();
		return nitrato;
	}

	public Page<Nitrato> findPageable(Integer page) {
		PageRequest pageRequest = new PageRequest(page, 2400, Direction.valueOf("DESC"), "id");
		return repo.findAll(pageRequest);
	}

}
