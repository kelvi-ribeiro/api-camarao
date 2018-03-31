package com.macuxi.camarao.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.macuxi.camarao.services.DBService;
import com.macuxi.camarao.services.EmailService;
import com.macuxi.camarao.services.SmtpEmailService;

@Configuration
@Profile("prod")
public class ProdConfig {

	@Autowired
	private DBService dbService;

	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbService.instantiateTestDatabase();
		return true;
	}
	
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
}