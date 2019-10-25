package com.epam.requester;

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
@EnableFeignClients(clients = {ExecutorUnoFeign.class, ExecutorTwoFeign.class})
public class RequesterApplication {

	public static void main(String[] args) {
		SpringApplication.run(RequesterApplication.class, args);
	}

	@Autowired
	private RequestsCaller requestsCaller;

	@GetMapping("one")
	public String getFromOne(){
		return requestsCaller.getRespondFromFirstExecutor("http://executor-one/give");
	}


	@GetMapping("two")
	public String getFromTwo(){
		return requestsCaller.getRespondFromSecondExecutor("http://executor-two/give");
	}
}
