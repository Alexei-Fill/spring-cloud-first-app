package com.epam.executortwo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableCircuitBreaker
@EnableFeignClients(clients = FirstExecutorFeign.class)
public class ExecutorTwoApplication implements ExecutorTwo {

	public static void main(String[] args) {
		SpringApplication.run(ExecutorTwoApplication.class, args);
	}

	@GetMapping("give")
	@Override
	public String give(){
		System.out.println("here in TOE");
		return "YoU reached the EXECUTOR TOE Two!!!\n   " + executorTwoCaller.getResultFromExecutorOne();
	}

	@Autowired
	ExecutorTwoCaller executorTwoCaller;
}
