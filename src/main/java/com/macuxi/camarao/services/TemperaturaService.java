package com.macuxi.camarao.services;

import org.springframework.stereotype.Service;

@Service
public class TemperaturaService {	
	
	public  int generateTemperatura() {
		int number = (int) (Math.random() * 30);		
		
		return number;
	}
}
