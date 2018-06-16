package com.macuxi.camarao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.macuxi.camarao.domain.AmoniaTotal;
import com.macuxi.camarao.repositories.AmoniaTotalRepository;

@Service
public class AmoniaTotalService {

	@Autowired
	AmoniaTotalRepository repo;

	public void generateAmoniaTotal() {
		AmoniaTotal amoniaTotal = new AmoniaTotal(null, (Math.random() * ((0.2 - 0.10) + 1) + 0.10));
		this.insert(amoniaTotal);
	}

	public AmoniaTotal insert(AmoniaTotal obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

	public AmoniaTotal findAmoniaTotal() {
		AmoniaTotal amoniaTotal = repo.findFirstByOrderByIdDesc();
		return amoniaTotal;
	}

	public Page<AmoniaTotal> findPageable(Integer page) {
		PageRequest pageRequest = new PageRequest(page, 2400, Direction.valueOf("DESC"), "id");
		return repo.findAll(pageRequest);
	}

}
