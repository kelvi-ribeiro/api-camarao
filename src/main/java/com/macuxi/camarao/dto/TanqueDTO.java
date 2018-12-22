package com.macuxi.camarao.dto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.macuxi.camarao.domain.Tanque;
import com.macuxi.camarao.domain.Usuario;

public class TanqueDTO {
	private int id;
	private String nome;
	private Double longitude;
	private Double latitude;
	private String horaRegistrado;
	private int usuarioId;
	private String nomeUsuario;
	private String urlFotoUsuario;

	public TanqueDTO() {

	}

	// public TanqueDTO(String longitude, String latitude, String horaRegistrado,) {
	// this.longitude = longitude;
	// this.mensagem = mensagem;
	// }

	public TanqueDTO(Tanque obj) {
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.longitude = obj.getLongitude();
		this.latitude = obj.getLatitude();
		this.horaRegistrado = fmt.format(obj.getHoraRegistrado());
		this.usuarioId = obj.getUsuario().getId();
		this.nomeUsuario = obj.getUsuario().getNome();
		this.urlFotoUsuario = obj.getUsuario().getUrlFoto();
	}

	public static Tanque returnEntity(TanqueDTO obj) {
		Usuario usuario = new Usuario();
		usuario.setId(obj.getUsuarioId());
		Tanque tanque = new Tanque();
		tanque.setNome(obj.getNome());
		tanque.setLongitude(obj.getLongitude());
		tanque.setLatitude(obj.getLatitude());
		tanque.setUsuario(usuario);
		return tanque;

	}

	public static List<TanqueDTO> returnListPojo(List<Tanque> list) {
		List<TanqueDTO> listDto = new ArrayList<TanqueDTO>();
		list.stream().forEach(x -> {
			listDto.add(new TanqueDTO(x));
		});
		return listDto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getHoraRegistrado() {
		return horaRegistrado;
	}

	public void setHoraRegistrado(String horaRegistrado) {
		this.horaRegistrado = horaRegistrado;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getUrlFotoUsuario() {
		return urlFotoUsuario;
	}

	public void setUrlFotoUsuario(String urlFotoUsuario) {
		this.urlFotoUsuario = urlFotoUsuario;
	}
	

}
