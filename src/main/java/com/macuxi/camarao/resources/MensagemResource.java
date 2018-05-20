package com.macuxi.camarao.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.macuxi.camarao.domain.Mensagem;
import com.macuxi.camarao.dto.MensagemDTO;
import com.macuxi.camarao.services.AndroidPushNotificationsService;
import com.macuxi.camarao.services.MensagemService;
import com.macuxi.camarao.services.UsuarioService;

@RestController
@RequestMapping(value="/mensagens")
public class MensagemResource {
	
	@Autowired
	private MensagemService service;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private AndroidPushNotificationsService androidPushNotificationsService;
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody MensagemDTO mensagemDto) throws JSONException {
		Mensagem obj = new Mensagem();
		obj = MensagemDTO.returnEntity(mensagemDto);		
		obj.setCliente(usuarioService.find(mensagemDto.getClienteId()));
		obj = service.insert(obj);
		androidPushNotificationsService.sendMessage(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<MensagemDTO>> findAll() {
		List<Mensagem> list = service.findAll();
		List<MensagemDTO> listDto = list.stream().map(obj -> new MensagemDTO(obj)).collect(Collectors.toList());
		//List<UsuarioDTO> listDto = list.stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/todos", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteAll() {
		service.deleteAll();
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

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