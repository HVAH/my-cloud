package com.mall.study.mybatis;

/**
 * @Description TODO
 * @Author HuangJiang
 * @Date 2018/9/7 10:05
 * @Version 1.0
 */
public class Test {
	public static void main(String[]args){
		MapperProxy mapperProxy = new MapperProxy();

		UserMapper userMapper = mapperProxy.newInstance(UserMapper.class);
		User user = userMapper.getUserById(1001);
		System.out.println(user);
		System.out.println(userMapper);
	}
}
