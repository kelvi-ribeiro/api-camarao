package com.macuxi.camarao.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.macuxi.camarao.domain.Transparencia;
import com.macuxi.camarao.services.TransparenciaService;

@RestController
@RequestMapping(value = "/transparencias")
public class TransparenciaResource {

	@Autowired
	TransparenciaService transparenciaService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Transparencia> find() throws Exception {
		Transparencia transparencia = transparenciaService.findTransparencia();
		return ResponseEntity.ok().body(transparencia);
	}

	@RequestMapping(value = "/paginada", method = RequestMethod.GET)
	public ResponseEntity<Page<Transparencia>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page) {
		Page<Transparencia> list = transparenciaService.findPageable(page);
		return ResponseEntity.ok().body(list);
	}

}
