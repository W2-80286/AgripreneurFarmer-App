package com.agri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.agri")
public class AgripreneurFarmerApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(AgripreneurFarmerApp1Application.class, args);
	}

}
