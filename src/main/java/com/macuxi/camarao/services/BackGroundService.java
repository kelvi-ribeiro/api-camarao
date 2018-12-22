package com.macuxi.camarao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class BackGroundService {

	@Autowired
	private TemperaturaService temperaturaService;

	@Autowired
	private PhService phService;

	@Autowired
	SalinidadeService salinidadeService;

	@Autowired
	AmoniaTotalService amoniaTotalService;

	@Autowired
	TransparenciaService transparenciaService;

	@Autowired
	NitritoService nitritoService;

	@Autowired
	OxigenioDissolvidoService oxigenioDissolvidoService;

	@Autowired
	NitratoService nitratoService;
	
	@Scheduled(fixedDelay = 10000)
	public void doInBackground() {
		temperaturaService.generateTemperatura();
		phService.generatePh();
		salinidadeService.generateSalinidade();
		amoniaTotalService.generateAmoniaTotal();
		transparenciaService.generateTransparencia();
		nitritoService.generateNitrito();
		oxigenioDissolvidoService.generateOxigenioDissolvido();
		nitratoService.generateNitrato();

	}

}
