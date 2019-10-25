package com.epam.executorone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class ExecutorOneApplication implements ExecutorOne {

	public static void main(String[] args) {
		SpringApplication.run(ExecutorOneApplication.class, args);
	}

	@GetMapping("give")
	@Override
	public String give(){
		System.out.println("here UNO");
		return "YoU reached the EXECUTOR UNO ONE!!!";
	}
}
