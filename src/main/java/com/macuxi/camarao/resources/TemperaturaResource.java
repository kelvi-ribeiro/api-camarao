package com.macuxi.camarao.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.macuxi.camarao.domain.Temperatura;
import com.macuxi.camarao.domain.Usuario;
import com.macuxi.camarao.dto.UsuarioNewDTO;
import com.macuxi.camarao.services.TemperaturaService;

@RestController
@RequestMapping(value="/temperaturas")
public class TemperaturaResource {
	
	@Autowired
	TemperaturaService temperaturaService;	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Temperatura> find() throws Exception{		
		Temperatura temperatura = temperaturaService.findTemperatura();
		return ResponseEntity.ok().body(temperatura);
	}
	
	@RequestMapping(value="/generateOut",method=RequestMethod.GET)
	public void generateTemperaturaAlertante() throws Exception{		
		temperaturaService.generateTemperaturaForaDoPadrao();
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert (@RequestBody Temperatura temperatura) {	
		Temperatura objInserido = new Temperatura();
		objInserido.setTemperatura(temperatura.getTemperatura());
		temperatura = temperaturaService.insert(objInserido);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(temperatura.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
