package com.macuxi.camarao.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.macuxi.camarao.domain.AmoniaTotal;
import com.macuxi.camarao.services.AmoniaTotalService;

@RestController
@RequestMapping(value="/amonias")
public class AmoniaTotalResource {
	
	@Autowired
	AmoniaTotalService amoniaTotalService;	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<AmoniaTotal> find() throws Exception{		
		AmoniaTotal amoniaTotal = amoniaTotalService.findAmoniaTotal();
		return ResponseEntity.ok().body(amoniaTotal);
	}
	
	@RequestMapping(value = "/paginada", method = RequestMethod.GET)
	public ResponseEntity<Page<AmoniaTotal>> findPage(
		@RequestParam(value = "page", defaultValue = "0") Integer page) {
		Page<AmoniaTotal> list = amoniaTotalService.findPageable(page);
		return ResponseEntity.ok().body(list);
	}
}
