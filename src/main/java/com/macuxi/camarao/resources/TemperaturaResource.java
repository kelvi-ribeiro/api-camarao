package com.macuxi.camarao.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.macuxi.camarao.domain.Temperatura;
import com.macuxi.camarao.services.BackGroundService;
import com.macuxi.camarao.services.TemperaturaService;

@RestController
@RequestMapping(value="/temperaturas")
public class TemperaturaResource {
	
	@Autowired
	TemperaturaService temperaturaService;
	
	@Autowired
	BackGroundService backgroundService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Temperatura> find() throws Exception{
		
		Temperatura temperatura = temperaturaService.findTemperatura();
		return ResponseEntity.ok().body(temperatura);
	}
	
	@RequestMapping(value="/start",method=RequestMethod.GET)
	public void start() throws Exception{
		backgroundService.doInBackground();
		//Temperatura temperatura = temperaturaService.generateTemperatura();
		//return ResponseEntity.ok().body(temperatura);
	}
	
	
	

}
