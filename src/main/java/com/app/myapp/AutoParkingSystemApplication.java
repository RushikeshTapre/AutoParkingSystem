package com.app.myapp;

import com.app.myapp.util.RandomPortUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.app.myapp")
public class AutoParkingSystemApplication {

	public static void main(String[] args) {
		RandomPortUtil.setRandomPort(5000, 10000);
		SpringApplication.run(AutoParkingSystemApplication.class, args);
	}
}
