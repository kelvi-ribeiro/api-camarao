package com.macuxi.camarao.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

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
@RequestMapping(value="/tanques")
public class TanqueResource {
	
	@Autowired
	private TanqueService service;
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody TanqueDTO tanqueDto)  {
		Tanque obj = new Tanque();
		obj = TanqueDTO.returnEntity(tanqueDto);		
		obj = service.insert(obj);		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<TanqueDTO>> findAll() {
		List<Tanque> list = service.findAll();
		List<TanqueDTO> listDto = list.stream().map(obj -> new TanqueDTO(obj)).collect(Collectors.toList());		//  
		return ResponseEntity.ok().body(listDto);
	}
	
//	@RequestMapping(value="/todos", method=RequestMethod.DELETE)
//	public ResponseEntity<Void> deleteAll() {
//		service.deleteAll();
//		return ResponseEntity.noContent().build();
//	}
//	
//	@PreAuthorize("hasAnyRole('ADMIN')")
//	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
//	public ResponseEntity<Void> delete(@PathVariable Integer id) {
//		service.delete(id);
//		return ResponseEntity.noContent().build();
//	}

//	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
//	public ResponseEntity<Void> update(@Valid @RequestBody UsuarioDTO objDto, @PathVariable Integer id) {
//		Usuario obj = service.fromDTO(objDto);
//		obj.setId(id);
//		obj = service.update(obj);
//		return ResponseEntity.noContent().build();
//	}
//	
//	@PreAuthorize("hasAnyRole('ADMIN')")
//	@RequestMapping(method=RequestMethod.GET)
//	public ResponseEntity<List<Usuario>> findAll() {
//		List<Usuario> list = service.findAll();
//		//List<UsuarioDTO> listDto = list.stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());  
//		return ResponseEntity.ok().body(list);
//	}
//	
//	@PreAuthorize("hasAnyRole('ADMIN')")
//	@RequestMapping(value="/page", method=RequestMethod.GET)
//	public ResponseEntity<Page<UsuarioDTO>> findPage(
//			@RequestParam(value="page", defaultValue="0") Integer page, 
//			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
//			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
//			@RequestParam(value="direction", defaultValue="ASC") String direction) {
//		Page<Usuario> list = service.findPage(page, linesPerPage, orderBy, direction);
//		Page<UsuarioDTO> listDto = list.map(obj -> new UsuarioDTO(obj));  
//		return ResponseEntity.ok().body(listDto);
//	}
//	
//	@RequestMapping(value="/picture", method=RequestMethod.POST)
//	public ResponseEntity<Void> uploadProfilePicture(@RequestParam(name="file") MultipartFile file) {
//		URI uri = service.uploadProfilePicture(file);
//		return ResponseEntity.created(uri).build();
//	}
//	
//	@RequestMapping(value="/mensagem", method=RequestMethod.POST)
//	public void sendMessage(@Valid @RequestBody MensagemDTO objDto) {		
//		try {
//			androidPushNotificationsService.sendMessage(objDto);
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}