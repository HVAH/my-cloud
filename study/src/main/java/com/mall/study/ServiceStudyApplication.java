package com.mall.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
@ServletComponentScan
public class ServiceStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceStudyApplication.class, args);
	}


	@Bean
	public ExecutorService executorService() {
		return Executors.newFixedThreadPool(500);
	}
}
