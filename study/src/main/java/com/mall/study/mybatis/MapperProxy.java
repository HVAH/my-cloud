package com.mall.study.mybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description TODO
 * @Author HuangJiang
 * @Date 2018/9/7 9:27
 * @Version 1.0
 */
public class MapperProxy implements InvocationHandler {

	public <T> T newInstance(Class<T> clazz) {
		return (T)Proxy.newProxyInstance(clazz.getClassLoader(), new  Class[] {clazz}, this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (Object.class.equals(method.getDeclaringClass())) {
			// 如果是Object声明的方法, 将target指向this
			try {
				return method.invoke(this, args);
			} catch (Throwable t) {
			}
		}
		// 没有执行目标对象的方法, 在此 Mybatis执行方法映射的sql并返回结果
		return new User((Integer) args[0], "zs", 18);
	}
}
