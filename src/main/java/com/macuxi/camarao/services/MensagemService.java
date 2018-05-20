package com.macuxi.camarao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macuxi.camarao.domain.Mensagem;
import com.macuxi.camarao.repositories.MensagemRepository;
import com.macuxi.camarao.services.exceptions.ObjectNotFoundException;

@Service
public class MensagemService {
	
	@Autowired
	private MensagemRepository repo;
	
	public Mensagem find(Integer id) {
		
		Mensagem obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Mensagem.class.getName());
		}
		return obj;
	}


	public List<Mensagem> findAll() {
		return repo.findAll();
	}
	
	public Mensagem insert(Mensagem obj) {
		obj.setId(null);
		obj = repo.save(obj);			
		return obj;
	}
	
	public void delete(Integer id) {
		find(id);		
		repo.delete(id);		
	}
	
	public void deleteAll() {		
		repo.deleteAll();		
	}
}