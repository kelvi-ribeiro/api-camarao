package com.macuxi.camarao.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.macuxi.camarao.domain.Nitrito;
import com.macuxi.camarao.services.NitritoService;

@RestController
@RequestMapping(value = "/nitritos")
public class NitritoResource {

	@Autowired
	NitritoService nitritoService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Nitrito> find() throws Exception {
		Nitrito nitrito = nitritoService.findNitrito();
		return ResponseEntity.ok().body(nitrito);
	}

	@RequestMapping(value = "/paginada", method = RequestMethod.GET)
	public ResponseEntity<Page<Nitrito>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page) {
		Page<Nitrito> list = nitritoService.findPageable(page);
		return ResponseEntity.ok().body(list);
	}
}
