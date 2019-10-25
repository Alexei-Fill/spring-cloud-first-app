package com.epam.requester;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RequestsCaller {

    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String getRespondFromFirstExecutor(String s) {
        return executorUnoFeign.give();
    }

    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String getRespondFromSecondExecutor(String s) {
        return executorTwoFeign.give();
    }

    public String fallbackMethod(String s) {
        return String.format("fuck something wrong with this url %s and there is a problem: %n ", s);
    }

    @Autowired
    ExecutorUnoFeign executorUnoFeign;

    @Autowired
    ExecutorTwoFeign executorTwoFeign;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
