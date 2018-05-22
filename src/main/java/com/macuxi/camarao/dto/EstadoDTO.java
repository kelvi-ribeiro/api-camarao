package com.macuxi.camarao.dto;

import java.io.Serializable;

import com.macuxi.camarao.domain.Tanque;

public class EstadoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String uf;
	private int idPais;

	public EstadoDTO() {

	}

	public EstadoDTO(Tanque obj) {
		id = obj.getId();
		nome = obj.getNome();
		uf = obj.getUf();
		idPais = obj.getPais().getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public int getIdPais() {
		return idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}

}
