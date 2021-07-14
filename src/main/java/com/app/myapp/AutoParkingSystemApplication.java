package com.app.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.app.myapp")
public class AutoParkingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoParkingSystemApplication.class, args);
	}

}
