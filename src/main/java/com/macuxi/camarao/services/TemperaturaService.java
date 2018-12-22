package com.macuxi.camarao.services;

import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.macuxi.camarao.domain.Temperatura;
import com.macuxi.camarao.domain.Usuario;
import com.macuxi.camarao.repositories.TemperaturaRepository;

@Service
public class TemperaturaService {

	@Autowired
	TemperaturaRepository repo;

	@Autowired
	EmailService emailService;

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	AndroidPushNotificationsService androidPushNotificationsService;

	public void generateTemperatura() {
		Temperatura temperatura = new Temperatura(null, (Math.random() * ((33 - 28) + 1) + 28));
		this.insert(temperatura);

	}

	public Temperatura insert(Temperatura obj) {
		obj.setId(null);
		if (obj.getTemperatura() <= 27 || obj.getTemperatura() >= 34) {
			List<Usuario> usuarios = usuarioService.findAll();
			// emailService.sendOrderConfirmationHtmlEmail(obj, usuarios);
			emailService.sendOrderConfirmationEmail(obj, usuarios);
			try {
				androidPushNotificationsService.send(obj);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		obj = repo.save(obj);
		return obj;
	}

	public Temperatura findTemperatura() {
		Temperatura temperatura = repo.findFirstByOrderByIdDesc();
		return temperatura;
	}

	public void generateTemperaturaForaDoPadrao() {
		Temperatura temperatura = new Temperatura(null, (Math.random() * ((22 - 20) + 1) + 20));
		this.insert(temperatura);

	}

	public Page<Temperatura> findPageable(Integer page) {
		PageRequest pageRequest = new PageRequest(page, 200, Direction.valueOf("DESC"), "id");
		return repo.findAll(pageRequest);
	}

}
