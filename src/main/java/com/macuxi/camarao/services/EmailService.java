package com.macuxi.camarao.services;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.macuxi.camarao.domain.Temperatura;
import com.macuxi.camarao.domain.Usuario;


public interface EmailService {

	void sendOrderConfirmationEmail(Temperatura obj,List<Usuario> usuarios);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendOrderConfirmationHtmlEmail(Temperatura obj,List<Usuario> usuarios);
	
	void sendHtmlEmail(MimeMessage msg);
	
	void sendNewPasswordEmail(Usuario usuario,String newPass);
}