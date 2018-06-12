package com.macuxi.camarao.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.macuxi.camarao.domain.Tanque;
import com.macuxi.camarao.dto.TanqueDTO;
import com.macuxi.camarao.services.TanqueService;

@RestController
@RequestMapping(value = "/tanques")
public class TanqueResource {

	@Autowired
	private TanqueService service;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody TanqueDTO tanqueDto) throws JSONException {
		Tanque obj = new Tanque();
		obj = TanqueDTO.returnEntity(tanqueDto);		
		obj = service.insert(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<TanqueDTO>> findAll() {
		List<Tanque> list = service.findAll();
		List<TanqueDTO> listDto = TanqueDTO.returnListPojo(list); 
		return ResponseEntity.ok().body(listDto);
	}

//	@RequestMapping(value = "/todos", method = RequestMethod.DELETE)
//	public ResponseEntity<Void> deleteAll() {
//		service.deleteAll();
//		return ResponseEntity.noContent().build();
//	}
//
//	@PreAuthorize("hasAnyRole('ADMIN')")
//	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<Void> delete(@PathVariable Integer id) {
//		service.delete(id);
//		return ResponseEntity.noContent().build();
//	}

}