package com.macuxi.camarao.dto;

import java.util.Date;

public class MensagemNotificacaoDTO {

	private String titulo;
	private String mensagem;
	private Date horaMarcada;	
	
	public MensagemNotificacaoDTO() {
		this.horaMarcada = new Date(System.currentTimeMillis());
	}

	public MensagemNotificacaoDTO(String titulo, String mensagem) {
		this.titulo = titulo;
		this.mensagem = mensagem;
		this.horaMarcada = new Date(System.currentTimeMillis());
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

	public Date getHoraMarcada() {
		return horaMarcada;
	}

	public void setHoraMarcada(Date horaMarcada) {
		this.horaMarcada = horaMarcada;
	}

}
