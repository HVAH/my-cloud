package com.mall.pay;

import com.mall.base.config.BaseConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(BaseConfig.class)
public class CoreServicePayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreServicePayApplication.class, args);
	}
}
