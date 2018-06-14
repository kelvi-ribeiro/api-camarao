package com.macuxi.camarao.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;

@Entity
public class Tanque implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;
	
	
	private Double longitude;
	
	
	private Double latitude;
	
	@Column(name = "hora_registrado")
	private Date horaRegistrado;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Tanque() {
		this.horaRegistrado = new Date(System.currentTimeMillis());
	}

	public Tanque(Integer id, Double longitude, Double latitude, String nome) {
		super();
		this.id = id;
		this.longitude = longitude;
		this.latitude = latitude;
		this.nome = nome;
		this.horaRegistrado = new Date(System.currentTimeMillis());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Date getHoraRegistrado() {
		return horaRegistrado;
	}

	public void setHoraRegistrado(Date horaRegistrado) {
		this.horaRegistrado = horaRegistrado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
