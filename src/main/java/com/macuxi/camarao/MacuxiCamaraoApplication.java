package com.macuxi.camarao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.macuxi.camarao.services.BackGroundService;

@SpringBootApplication
public class MacuxiCamaraoApplication {

	@Autowired
	BackGroundService backgroundService;

	public static void main(String[] args) {
		SpringApplication.run(MacuxiCamaraoApplication.class, args);
	}

}
