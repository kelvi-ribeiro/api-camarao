package com.macuxi.camarao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macuxi.camarao.domain.Ph;
import com.macuxi.camarao.repositories.PhRepository;

@Service
public class PhService {	
	
	@Autowired
	PhRepository repo;	
	
	public  void generatePh() {
		Ph ph =  new Ph(null,(Math.random() *((8.3 - 7.8) + 1) + 8.3));
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
	
}
