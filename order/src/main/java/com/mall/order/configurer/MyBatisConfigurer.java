package com.mall.order.configurer;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.util.Properties;


//@Configuration
//@EnableTransactionManagement
public class MyBatisConfigurer implements TransactionManagementConfigurer {
	private @Autowired DataSource dataSource;

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactoryBean() {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setTypeAliasesPackage("com.mall.*.domain");
		Properties sqlSessionFactoryProperties = new Properties();
		sqlSessionFactoryProperties.setProperty("cacheEnabled", "false");
		sqlSessionFactoryProperties.setProperty("lazyLoadingEnabled", "false");
		sqlSessionFactoryProperties.setProperty("multipleResultSetsEnabled", "false");

		sqlSessionFactoryProperties.setProperty("useColumnLabel", "true");
		sqlSessionFactoryProperties.setProperty("mapUnderscoreToCamelCase", "true");
		sqlSessionFactoryProperties.setProperty("useGeneratedKeys", "true");
		sqlSessionFactoryProperties.setProperty("autoMappingBehavior", "PARTIAL");
		sqlSessionFactoryProperties.setProperty("defaultExecutorType", "REUSE");
		sqlSessionFactoryProperties.setProperty("defaultStatementTimeout", "25000");

		bean.setConfigurationProperties(sqlSessionFactoryProperties);

		// 分页插件
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("dialect", "mysql");
		properties.setProperty("offsetAsPageNum", "true");
		properties.setProperty("rowBoundsWithCount", "false");
		properties.setProperty("pageSizeZero", "false");
		properties.setProperty("reasonable", "false");
		properties.setProperty("supportMethodsArguments", "false");
		properties.setProperty("returnPageInfo", "none");
		pageHelper.setProperties(properties);

		// 添加插件
		bean.setPlugins(new Interceptor[] { pageHelper });

		// 添加XML目录
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		try {
			bean.setMapperLocations(resolver.getResources("classpath:mapper/**/*Mapper.xml"));
			return bean.getObject();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

	@Bean
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}
}