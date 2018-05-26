package com.macuxi.camarao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macuxi.camarao.domain.Arduino;
import com.macuxi.camarao.domain.Tanque;
import com.macuxi.camarao.repositories.ArduinoRepository;
import com.macuxi.camarao.services.exceptions.ObjectNotFoundException;

@Service
public class ArduinoService {

	@Autowired
	private ArduinoRepository repo;

	public Arduino find(Integer id) {

		Arduino obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Arduino.class.getName());
		}
		return obj;
	}

	public List<Arduino> findAll() {
		return repo.findAll();
	}

	public Arduino insert(Arduino obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

	public void delete(Integer id) {
		find(id);
		repo.delete(id);
	}
}