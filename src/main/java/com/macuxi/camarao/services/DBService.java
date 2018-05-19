package com.macuxi.camarao.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.macuxi.camarao.domain.Cidade;
import com.macuxi.camarao.domain.Endereco;
import com.macuxi.camarao.domain.Estado;
import com.macuxi.camarao.domain.Pais;
import com.macuxi.camarao.domain.Usuario;
import com.macuxi.camarao.domain.enums.Perfil;
import com.macuxi.camarao.repositories.CidadeRepository;
import com.macuxi.camarao.repositories.EnderecoRepository;
import com.macuxi.camarao.repositories.EstadoRepository;
import com.macuxi.camarao.repositories.PaisRepository;
import com.macuxi.camarao.repositories.UsuarioRepository;


@Service
public class DBService {

	@Autowired
	private BCryptPasswordEncoder pe;	
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired	
	private UsuarioRepository usuarioRepository;
	
	@Autowired	
	private EnderecoRepository enderecoRepository;	
	
	@Autowired	
	private PaisRepository paisRepository;	
	
	public void instantiateTestDatabase() throws Exception {
		
//		Pais pais = new Pais(null, "Brsil", "BR");
//		
//		paisRepository.save(pais);
//		
//		Estado est1 = new Estado(null, "Rio de Janeiro", "RJ", pais);
//		Estado est2 = new Estado(null, "São Paulo", "SP", pais);		
//		Estado est3 = new Estado(null, "Ceará", "CR", pais);
//		
//		Cidade c1 = new Cidade(null, "Belford Roxo", est1);
//		Cidade c2 = new Cidade(null, "São Paulo", est2);
//		Cidade c3 = new Cidade(null, "Aracaú", est3);
//		
//		est1.getCidades().addAll(Arrays.asList(c1));
//		est2.getCidades().addAll(Arrays.asList(c2, c3));
//
//		estadoRepository.save(Arrays.asList(est1, est2,est3));
//		cidadeRepository.save(Arrays.asList(c1, c2, c3));
//		
//		Usuario us2 = new Usuario(null, "Thiago Souza", "kelvi.ribeiro@gmail.com", "31628382740", pe.encode("123"));
//		us2.getTelefones().addAll(Arrays.asList("93883321", "34252625"));
//		us2.addPerfil(Perfil.ADMIN);
//		
//		Usuario us1 = new Usuario(null, "Kelvi Martins", "kelvi.ribeiro@unigranrio.br", "36378912377", pe.encode("123"));
//		us1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
//		
//		Usuario us3 = new Usuario(null, "Felipe Lamin", "k.vi123@hotmail.com", "53893776052", pe.encode("123"));
//		us3.getTelefones().addAll(Arrays.asList("27582490", "966749309"));
//		
//		Usuario us4 = new Usuario(null, "Wagner Fragoso", "pedro.femea@gmail.com", "34333840023", pe.encode("123"));
//		us4.getTelefones().addAll(Arrays.asList("37716309", "86743921"));
//		
//		
//		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", us1, c1);
//		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", us1, c2);
//		Endereco e3 = new Endereco(null, "Avenida Floriano", "2106", null, "Centro", "281777012", us2, c2);
//		Endereco e4 = new Endereco(null, "AV ANA TEREZA DE JESUS", "160", null, "Centro", "	35591100", us3, c3);
//		Endereco e5 = new Endereco(null, "AV GEN AFONSO ALBUQUERQUE LIMA", "3", null, "CAMBEBA", "	32077876", us4, c3);
//		
//		us1.getEnderecos().addAll(Arrays.asList(e1, e2));
//		us2.getEnderecos().addAll(Arrays.asList(e3));
//		us3.getEnderecos().addAll(Arrays.asList(e4));
//		
//		usuarioRepository.save(Arrays.asList(us1, us2,us3,us4));
//		enderecoRepository.save(Arrays.asList(e1, e2, e3,e4,e5));
		
		
		
}
}