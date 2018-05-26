package com.macuxi.camarao.dto;

import com.macuxi.camarao.domain.Tanque;
import com.macuxi.camarao.domain.Usuario;

public class TanqueDTO {
	private int id;
	private String nome;
	private String codigo;
	private int usuarioId;
	private int arduinoId;
	private String arduinoNome;

	public TanqueDTO() {

	}

	public TanqueDTO(int id, String nome, String codigo, int usuarioId, String arduinoNome, int arduinoId) {
		this.id = id;
		this.nome = nome;
		this.codigo = codigo;
		this.usuarioId = usuarioId;
		this.arduinoId = arduinoId;
	}

	public TanqueDTO(Tanque obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.codigo = obj.getCodigo();
		this.arduinoId = obj.getArduino() != null ? obj.getArduino().getId():0; 
		this.arduinoNome = obj.getArduino() != null ? obj.getArduino().getNome():null;
		this.usuarioId = obj.getUsuario() != null  ? obj.getArduino().getId():null;

	}

	public static Tanque returnEntity(TanqueDTO obj) {
		Usuario usuario = new Usuario();
		usuario.setId(obj.getUsuarioId());
		Tanque tanque = new Tanque();
		tanque.setId(obj.getId());
		tanque.setCodigo(obj.getCodigo());
		tanque.setUsuario(usuario);
		return tanque;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getArduinoNome() {
		return arduinoNome;
	}

	public void setArduinoNome(String arduinoNome) {
		this.arduinoNome = arduinoNome;
	}

	public int getArduinoId() {
		return arduinoId;
	}

	public void setArduinoId(int arduinoId) {
		this.arduinoId = arduinoId;
	}

}
