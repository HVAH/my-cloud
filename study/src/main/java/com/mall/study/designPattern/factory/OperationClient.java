package com.mall.study.designPattern.factory;

/**
 * @Description 计算器客户端
 * @Author HuangJiang
 * @Date 2018/8/30 18:04
 * @Version 1.0
 */
public class OperationClient {
	 public static void main(String[]args){
	 	// 使用简单工厂需要在客户端代码维护两个类
		 Operation operation = OperationFactory.createOperation("*");
		 operation.setNumber1(10);
		 operation.setNumber2(20);

		 System.out.println(operation.getResult());
	 }
}
