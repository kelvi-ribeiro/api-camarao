package com.macuxi.camarao.domain;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Arduino implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String codigo;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "tanque_id",nullable=false)
	private Tanque tanque;

	@OneToOne
	@JoinColumn(name = "amonia_id")
	private AmoniaTotal amoniaTotal;
	@OneToOne
	@JoinColumn(name = "nitrato_id")
	private Nitrato nitrato;
	@OneToOne
	@JoinColumn(name = "nitrito_id")
	private Nitrito nitrito;
	@OneToOne
	@JoinColumn(name = "oxigenio_dissolvido_id")
	private OxigenioDissolvido oxigenioDissolvido;
	@OneToOne
	@JoinColumn(name = "ph_id")
	private Ph ph;
	@OneToOne
	@JoinColumn(name = "salinidade_id")
	private Salinidade salinidade;
	@OneToOne
	@JoinColumn(name = "temperatura_id")
	private Temperatura temperatura;
	@OneToOne
	@JoinColumn(name = "transparencia_id")
	private Transparencia transparencia;

	public Arduino() {
	}

	public Arduino(Integer id, String nome, String codigo, Tanque tanque) {
		super();
		this.id = id;
		this.nome = nome;
		this.codigo = codigo;
		this.tanque = tanque;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Tanque getTanque() {
		return tanque;
	}

	public void setTanque(Tanque tanque) {
		this.tanque = tanque;
	}

	public AmoniaTotal getAmoniaTotal() {
		return amoniaTotal;
	}

	public void setAmoniaTotal(AmoniaTotal amoniaTotal) {
		this.amoniaTotal = amoniaTotal;
	}

	public Nitrato getNitrato() {
		return nitrato;
	}

	public void setNitrato(Nitrato nitrato) {
		this.nitrato = nitrato;
	}

	public Nitrito getNitrito() {
		return nitrito;
	}

	public void setNitrito(Nitrito nitrito) {
		this.nitrito = nitrito;
	}

	public OxigenioDissolvido getOxigenioDissolvido() {
		return oxigenioDissolvido;
	}

	public void setOxigenioDissolvido(OxigenioDissolvido oxigenioDissolvido) {
		this.oxigenioDissolvido = oxigenioDissolvido;
	}

	public Ph getPh() {
		return ph;
	}

	public void setPh(Ph ph) {
		this.ph = ph;
	}

	public Salinidade getSalinidade() {
		return salinidade;
	}

	public void setSalinidade(Salinidade salinidade) {
		this.salinidade = salinidade;
	}

	public Temperatura getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Temperatura temperatura) {
		this.temperatura = temperatura;
	}

	public Transparencia getTransparencia() {
		return transparencia;
	}

	public void setTransparencia(Transparencia transparencia) {
		this.transparencia = transparencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arduino other = (Arduino) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
