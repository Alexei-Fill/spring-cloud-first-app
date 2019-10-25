package com.epam.executortwo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ExecutorTwoCaller {

    @HystrixCommand(fallbackMethod = "fallbackMethodTwo")
    public String getResultFromExecutorOne() {
        return firstExecutorFeign.give();
    }

    public String fallbackMethodTwo() {
        return "why second executor work while first don't?";
    }

    @Autowired
    FirstExecutorFeign firstExecutorFeign;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
