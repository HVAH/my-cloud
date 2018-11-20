package com.mall.order.configurer;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

/**
 * Mapper自动扫描包配置
 * 
 * @author Cobain
 * @category 描述功能
 * @version 2016-10-08 初始化
 */
//@Configuration
//@AutoConfigureAfter(MyBatisConfigurer.class)
public class MyBatisMapperScannerConfigurer {

	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		mapperScannerConfigurer.setBasePackage("com.mall.*.repository");
		return mapperScannerConfigurer;
	}

}