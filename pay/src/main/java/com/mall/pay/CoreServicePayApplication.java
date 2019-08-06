package com.mall.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CoreServicePayApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CoreServicePayApplication.class, args);
		DataSourceAutoConfiguration bean = context.getBean(DataSourceAutoConfiguration.class);
		System.out.println(bean);
	}
}
