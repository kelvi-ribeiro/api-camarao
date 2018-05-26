package com.macuxi.camarao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macuxi.camarao.domain.Mensagem;
import com.macuxi.camarao.domain.Tanque;
import com.macuxi.camarao.repositories.TanqueRepository;
import com.macuxi.camarao.services.exceptions.ObjectNotFoundException;

@Service
public class TanqueService {

	@Autowired
	private TanqueRepository repo;

	public Tanque find(Integer id) {

		Tanque obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Tanque.class.getName());
		}
		return obj;
	}

	public List<Tanque> findAll() {
		return repo.findAll();
	}

	public Tanque insert(Tanque obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

	public void delete(Integer id) {
		find(id);
		repo.delete(id);
	}
}