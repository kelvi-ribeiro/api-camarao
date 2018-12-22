package com.macuxi.camarao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.macuxi.camarao.services.DBService;

@SpringBootApplication
public class MacuxiCamaraoApplication {

	@Autowired
	DBService DBService;

	public static void main(String[] args) {
		SpringApplication.run(MacuxiCamaraoApplication.class, args);
	}

	public void run(String... args) throws Exception {
		DBService.instantiateTestDatabase();
	}

}
