package com.saude.agenda.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class ApiApplication {

	// TODO: Resolver problema medicalRecordController
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
