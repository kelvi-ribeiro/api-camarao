package com.macuxi.camarao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macuxi.camarao.domain.Temperatura;
import com.macuxi.camarao.repositories.TemperaturaRepository;


@Service
public class TemperaturaService {
	
	Integer numeroMaior  = 0;
	@Autowired
	TemperaturaRepository repo;
	
	
	public  void generateTemperatura() {
		Temperatura temperatura =  new Temperatura(null,(Math.random() *((32 - 25) + 1) + 25));
		this.insert(temperatura);
		
	}
	
	public Temperatura insert(Temperatura obj) {
		obj.setId(null);
		obj = repo.save(obj);		
		return obj;
	}
	
	public Temperatura findTemperatura() {		
		List<Temperatura> temperaturas = repo.findAll();
		temperaturas.stream().forEach(x->{
			if(this.numeroMaior<x.getId()) {
				this.numeroMaior = x.getId();
			}
		
			
		});
		Temperatura temperatura = repo.findOne(numeroMaior);
		return temperatura;
	}
	

}
