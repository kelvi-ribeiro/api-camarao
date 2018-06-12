package com.macuxi.camarao.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Tanque implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String longitude;

	private String latitude;

	@Column(name = "hora_registrado")
	private Date horaRegistrado;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Tanque() {
		this.horaRegistrado = new Date(System.currentTimeMillis());
	}

	public Tanque(Integer id, String longitude, String latitude) {
		super();
		this.id = id;
		this.longitude = longitude;
		this.latitude = latitude;
		this.horaRegistrado = new Date(System.currentTimeMillis());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
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
