package com.macuxi.camarao.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.macuxi.camarao.domain.Nitrato;
import com.macuxi.camarao.services.NitratoService;

@RestController
@RequestMapping(value = "/nitratos")
public class NitratoResource {

	@Autowired
	NitratoService nitratoService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Nitrato> find() throws Exception {
		Nitrato nitrato = nitratoService.findNitrato();
		return ResponseEntity.ok().body(nitrato);
	}

	@RequestMapping(value = "/paginada", method = RequestMethod.GET)
	public ResponseEntity<Page<Nitrato>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page) {
		Page<Nitrato> list = nitratoService.findPageable(page);
		return ResponseEntity.ok().body(list);
	}
}
