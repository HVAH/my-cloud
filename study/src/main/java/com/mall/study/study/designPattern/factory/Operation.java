package com.mall.study.study.designPattern.factory;

/**
 * @Description 运算父类
 * @Author HuangJiang
 * @Date 2018/8/30 17:56
 * @Version 1.0
 */
public class Operation {

	private double number1;
	private double number2;

	public double getResult() {
		return 0;
	}


	public double getNumber1() {
		return number1;
	}

	public void setNumber1(double number1) {
		this.number1 = number1;
	}

	public double getNumber2() {
		return number2;
	}

	public void setNumber2(double number2) {
		this.number2 = number2;
	}
}
