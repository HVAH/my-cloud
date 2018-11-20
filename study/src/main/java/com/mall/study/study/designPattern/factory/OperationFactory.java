package com.mall.study.study.designPattern.factory;

/**
 * @Description 运算工厂类
 * @Author HuangJiang
 * @Date 2018/8/31 10:33
 * @Version 1.0
 */
public class OperationFactory {

	public static Operation createOperation(String operate) {
		Operation operation = null;

		switch (operate) {
			case "+":
				operation = new OperationAdd();
				break;
			case "-":
				operation = new OperationSub();
				break;
			case "*":
				operation = new OperationMul();
				break;
			case "/":
				operation = new OperationDiv();
				break;
		}

		return operation;
	}
}
