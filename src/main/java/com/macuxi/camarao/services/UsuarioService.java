package com.macuxi.camarao.services;

import java.awt.image.BufferedImage;
import java.net.URI;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.macuxi.camarao.domain.Cidade;
import com.macuxi.camarao.domain.Endereco;
import com.macuxi.camarao.domain.Usuario;
import com.macuxi.camarao.domain.enums.Perfil;
import com.macuxi.camarao.dto.UsuarioDTO;
import com.macuxi.camarao.dto.UsuarioNewDTO;
import com.macuxi.camarao.repositories.CidadeRepository;
import com.macuxi.camarao.repositories.EnderecoRepository;
import com.macuxi.camarao.repositories.UsuarioRepository;
import com.macuxi.camarao.security.UserSS;
import com.macuxi.camarao.services.exceptions.AuthorizationException;
import com.macuxi.camarao.services.exceptions.DataIntegrityException;
import com.macuxi.camarao.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Value("${img.profile.size}")
	private int size;

	@Value("${img.prefix.client.profile}")
	private String prefix;

	@Autowired
	private BCryptPasswordEncoder pe;

	@Autowired
	private UsuarioRepository repo;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private ImageService imageService;

	@Autowired
	private S3Service s3Service;
	
	private Random rand = new Random();

	public Usuario find(Integer id) {

		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}

		Usuario obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName());
		}
		return obj;
	}

	public Usuario insert(Usuario obj) {
		obj.setId(null);
		obj = repo.save(obj);
		enderecoRepository.save(obj.getEnderecos());
		return obj;
	}

	public Usuario update(Usuario obj) {
		Usuario newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.delete(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
		}
	}

	public List<Usuario> findAll() {
		return repo.findAll();
	}

	public Usuario findByEmail(String email) {

		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN) && !email.equals(user.getUsername())) {
			throw new AuthorizationException("Acesso negado");
		}

		Usuario obj = repo.findByEmail(email);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + user.getId() + ", Tipo: " + Usuario.class.getName());
		}
		return obj;
	}

	public Page<Usuario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Usuario fromDTO(UsuarioDTO objDto) {
		return new Usuario(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
	}

	public Usuario fromDTO(UsuarioNewDTO objDto) {
		Usuario cli = new Usuario(null, objDto.getNome(), objDto.getEmail(), objDto.getCpf(),
				pe.encode(objDto.getSenha()));
		Cidade cid = cidadeRepository.findOne(objDto.getCidadeId());
		Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(),
				objDto.getBairro(), objDto.getCep(), cli, cid);
		cli.getEnderecos().add(end);
		cli.getTelefones().add(objDto.getTelefone1());
		if (objDto.getTelefone2() != null) {
			cli.getTelefones().add(objDto.getTelefone2());
		}
		if (objDto.getTelefone3() != null) {
			cli.getTelefones().add(objDto.getTelefone3());
		}
		return cli;
	}

	private void updateData(Usuario newObj, Usuario obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}

	public URI uploadProfilePicture(MultipartFile multipartFile) {

		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}

		BufferedImage jpgImage = imageService.getJpgImageFromFile(multipartFile);
		

		String fileName =  "id="+ user.getId() + "&rand=" + this.newStringRandom() + ".jpg";
		Usuario usuario =  repo.findOne(user.getId());		
		usuario.setUrlFoto(fileName);
		repo.save(usuario);
		return s3Service.uploadFile(imageService.getInputStream(jpgImage, "jpg"), fileName, "image");

	}

	private char randomChar() {
		int opt = rand.nextInt(3);
		if (opt == 0) { // gera um digito
			return (char) (rand.nextInt(10) + 48);
		} else if (opt == 1) { // gera letra maiuscula
			return (char) (rand.nextInt(26) + 65);
		} else { // gera letra minuscula
			return (char) (rand.nextInt(26) + 97);
		}

	}
	private String newStringRandom() {
		char[] vet = new char[10];
		for (int i=0; i<10; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}
}