package com.macuxi.camarao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.macuxi.camarao.domain.OxigenioDissolvido;
import com.macuxi.camarao.repositories.OxigenioDissolvidoRepository;

@Service
public class OxigenioDissolvidoService {

	@Autowired
	OxigenioDissolvidoRepository repo;

	public void generateOxigenioDissolvido() {
		OxigenioDissolvido oxigenioDissolvido = new OxigenioDissolvido(null,
				(Math.random() * ((10 - 5.50) + 1) + 5.50));
		this.insert(oxigenioDissolvido);

	}

	public OxigenioDissolvido insert(OxigenioDissolvido obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

	public OxigenioDissolvido findOxigenioDissolvido() {
		OxigenioDissolvido oxigenioDissolvido = repo.findFirstByOrderByIdDesc();
		return oxigenioDissolvido;
	}

	public Page<OxigenioDissolvido> findPageable(Integer page) {
		PageRequest pageRequest = new PageRequest(page, 200, Direction.valueOf("DESC"), "id");
		return repo.findAll(pageRequest);
	}

}
