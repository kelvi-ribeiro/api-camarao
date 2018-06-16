package com.macuxi.camarao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.macuxi.camarao.domain.Salinidade;
import com.macuxi.camarao.repositories.SalinidadeRepository;

@Service
public class SalinidadeService {

	@Autowired
	SalinidadeRepository repo;

	public void generateSalinidade() {
		Salinidade salinidade = new Salinidade(null, (Math.random() * ((20 - 25) + 1) + 25));
		this.insert(salinidade);
	}

	public Salinidade insert(Salinidade obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

	public Salinidade findSalinidade() {
		Salinidade salinidade = repo.findFirstByOrderByIdDesc();
		return salinidade;
	}
	
	public Page<Salinidade> findPageable(Integer page) {
		PageRequest pageRequest = new PageRequest(page, 2400, Direction.valueOf("DESC"), "id");
		return repo.findAll(pageRequest);
	}

}
