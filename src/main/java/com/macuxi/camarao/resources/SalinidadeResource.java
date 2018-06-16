package com.macuxi.camarao.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.macuxi.camarao.domain.Salinidade;
import com.macuxi.camarao.services.SalinidadeService;

@RestController
@RequestMapping(value = "/salinidades")
public class SalinidadeResource {

	@Autowired
	SalinidadeService salinidadeService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Salinidade> find() throws Exception {
		Salinidade salinidade = salinidadeService.findSalinidade();
		return ResponseEntity.ok().body(salinidade);
	}

	@RequestMapping(value = "/paginada", method = RequestMethod.GET)
	public ResponseEntity<Page<Salinidade>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page) {
		Page<Salinidade> list = salinidadeService.findPageable(page);
		return ResponseEntity.ok().body(list);
	}

}
