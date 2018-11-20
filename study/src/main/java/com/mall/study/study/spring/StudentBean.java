package com.mall.study.study.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * @description: 测试bean的生命周期
 * @author: huangjiang  2018年6月15日 上午11:17:54
 */
public class StudentBean implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware {
	private int age;
	private String name;
	
	// 实现了BeanNameWare接口,Spring可以将BeanName注入该属性
	private  String beanName;
	// 实现了BeanFactory接口,Spring可以将BeanFactory注入该属性
	private BeanFactory beanFactory;
	
	/**
	 * @description: 自己编写的初始化方法 
	 * @author: huangjiang  2018年6月15日 上午11:26:18
	 *
	 */
	public void myInnit() {
		System.out.println("【init-method】调用init-method属性配置的初始化方法");
	}
	
	/**
	 * @description: 自己编写的销毁方法 
	 * @author: huangjiang  2018年6月15日 上午11:33:51
	 *
	 */
	public void myDestory() {
		System.out.println("【destroy-method】调用destroy-method属性配置的销毁方法");
	}
	
	/**
	 * 实现BeanFactoryAware接口的方法
	 */
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
		System.out.println("【BeanFactoryAware接口】调用BeanFactoryAware的setBeanFactory方法得到beanFactory引用");
	}

	/**
	 * 实现 BeanNameAware接口的方法
	 */
	@Override
	public void setBeanName(String name) {
		this.beanName = name;
		System.out.println("【BeanNameAware接口】调用BeanNameAware的setBeanName方法得到Bean的名称");
	}
	
	/**
	 * 实现DisposableBean接口的方法
	 */
	@Override
	public void destroy() throws Exception {
		System.out.println("【DisposableBean接口】调用DisposableBean接口的destroy方法");
	}
	
	
	@Override
	public void afterPropertiesSet() throws Exception {
	}
	
	
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "StudentBean [age=" + age + ", name=" + name + ", beanName=" + beanName + "]";
	}
	
}
