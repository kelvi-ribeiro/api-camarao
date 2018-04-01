package com.macuxi.camarao.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.macuxi.camarao.services.TemperaturaService;

@RestController
@RequestMapping(value="/temperaturas")
public class TemperaturaResource {
	
	@Autowired
	TemperaturaService temperaturaSerivce;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Integer> find(){
		 int number = temperaturaSerivce.generateTemperatura();
		return ResponseEntity.ok().body(number);
	}
	

}
