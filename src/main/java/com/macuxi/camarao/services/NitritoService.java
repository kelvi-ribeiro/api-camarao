package com.macuxi.camarao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.macuxi.camarao.domain.Nitrito;
import com.macuxi.camarao.repositories.NitritoRepository;

@Service
public class NitritoService {

	@Autowired
	NitritoRepository repo;

	public void generateNitrito() {
		Nitrito nitrito = new Nitrito(null, (Math.random() * ((0.50 - 0.0) + 1) + 0.0));
		this.insert(nitrito);

	}

	public Nitrito insert(Nitrito obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

	public Nitrito findNitrito() {
		Nitrito nitrito = repo.findFirstByOrderByIdDesc();
		return nitrito;
	}

	public Page<Nitrito> findPageable(Integer page) {
		PageRequest pageRequest = new PageRequest(page, 2400, Direction.valueOf("DESC"), "id");
		return repo.findAll(pageRequest);
	}

}
