package com.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableZuulProxy
@SpringBootApplication
public class ApiPcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiPcApplication.class, args);
    }
}
