package com.macuxi.camarao.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.macuxi.camarao.domain.Ph;
import com.macuxi.camarao.services.PhService;

@RestController
@RequestMapping(value = "/phs")
public class PhResource {

	@Autowired
	PhService phService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Ph> find() throws Exception {
		Ph ph = phService.findPh();
		return ResponseEntity.ok().body(ph);
	}

	@RequestMapping(value="/paginada",method=RequestMethod.GET)
	public ResponseEntity<Page<Ph>> findPage(	 
			
			@RequestParam(value="page",defaultValue="0")Integer page){
				
		Page<Ph> list = phService.findPhPageable(page);		
		return ResponseEntity.ok().body(list);
	}
}
