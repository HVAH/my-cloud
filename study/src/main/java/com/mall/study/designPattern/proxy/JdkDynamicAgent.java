package com.mall.study.designPattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description
 * @Author Jiang
 * @Date 2019/7/22 16:05
 * @Version 1.0
 **/
public class JdkDynamicAgent {
    
    public static class MyHandler implements InvocationHandler {
        
        private Object beProxy;
        public MyHandler(Object beProxy) {
            this.beProxy = beProxy;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("before");
            Object result = method.invoke(this.beProxy, args);
            System.out.println("after");
            return result;
        }
    }
    
    
    public static <T> T getAgency(Class<T> inerfaceClass, Object beProxy) {
        return (T)Proxy.newProxyInstance(inerfaceClass.getClassLoader(), new Class[]{inerfaceClass}, new MyHandler(beProxy));
    }

    
    public static void main(String[] args) {
        Fruit fruit = JdkDynamicAgent.getAgency(Fruit.class, new Apple());
        fruit.name();
    }
}
