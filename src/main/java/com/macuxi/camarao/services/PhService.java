package com.macuxi.camarao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.macuxi.camarao.domain.Ph;
import com.macuxi.camarao.repositories.PhRepository;

@Service
public class PhService {

	@Autowired
	PhRepository repo;

	public void generatePh() {
		Ph ph = new Ph(null, (Math.random() * ((8.3 - 7.8) + 1) + 7.8));
		this.insert(ph);

	}

	public Ph insert(Ph obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

	public Ph findPh() {
		Ph ph = repo.findFirstByOrderByIdDesc();
		return ph;
	}

	public Page<Ph> findPageable(Integer page) {
		PageRequest pageRequest = new PageRequest(page, 200, Direction.valueOf("DESC"), "id");
		return repo.findAll(pageRequest);
	}

}
