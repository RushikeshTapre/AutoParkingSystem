package com.app.myapp;

import com.app.myapp.controller.CarController;
import com.app.myapp.util.RandomPortUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.app.myapp")
public class AutoParkingSystemApplication {

	private static final Logger logger= LoggerFactory.getLogger(AutoParkingSystemApplication.class);

	public static void main(String[] args) {

		logger.info("App Started..!!");
		RandomPortUtil.setRandomPort(5000, 10000);
		SpringApplication.run(AutoParkingSystemApplication.class, args);
	}
}
