package com.macuxi.camarao.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.macuxi.camarao.domain.OxigenioDissolvido;
import com.macuxi.camarao.services.OxigenioDissolvidoService;

@RestController
@RequestMapping(value = "/oxigenioDissolvidos")
public class OxigenioDissolvidoResource {

	@Autowired
	OxigenioDissolvidoService oxigenioDissolvidoService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<OxigenioDissolvido> find() throws Exception {
		OxigenioDissolvido oxigenioDissolvido = oxigenioDissolvidoService.findOxigenioDissolvido();
		return ResponseEntity.ok().body(oxigenioDissolvido);
	}

	@RequestMapping(value = "/paginada", method = RequestMethod.GET)
	public ResponseEntity<Page<OxigenioDissolvido>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page) {
		Page<OxigenioDissolvido> list = oxigenioDissolvidoService.findPageable(page);
		return ResponseEntity.ok().body(list);
	}
}
