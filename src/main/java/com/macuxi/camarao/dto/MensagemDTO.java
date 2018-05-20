package com.macuxi.camarao.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.macuxi.camarao.domain.Mensagem;

public class MensagemDTO {
	private int id;
	private String titulo;
	private String mensagem;
	private String horaMarcada;
	private int clienteId;
	private String nomeCliente;

	public MensagemDTO() {
		
	}

	public MensagemDTO(String titulo, String mensagem) {
		this.titulo = titulo;
		this.mensagem = mensagem;		
	}

	public MensagemDTO(Mensagem obj) {
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		id = obj.getId();
		titulo = obj.getTitulo();
		mensagem = obj.getMensagem();
		horaMarcada = fmt.format(obj.getHoraMarcada());
		clienteId = obj.getCliente().getId();
		nomeCliente = obj.getCliente().getNome();
	}

	public static Mensagem returnEntity(MensagemDTO obj) {
		Mensagem mensagem = new Mensagem();
		mensagem.setMensagem(obj.getMensagem());
		mensagem.setTitulo(obj.getTitulo());		
		return mensagem;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getHoraMarcada() {
		return horaMarcada;
	}

	public void setHoraMarcada(String horaMarcada) {
		this.horaMarcada = horaMarcada;
	}

	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

}
