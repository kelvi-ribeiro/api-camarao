package com.macuxi.camarao.services;

import org.springframework.stereotype.Service;

@Service
public class PhService {	
	
	public  int generatePh() {
		int number = (int) (Math.random() * 25);		
		
		return number;
	}
}
