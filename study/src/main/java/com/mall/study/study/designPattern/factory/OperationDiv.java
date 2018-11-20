package com.mall.study.study.designPattern.factory;

/**
 * @Description 除法
 * @Author HuangJiang
 * @Date 2018/8/31 10:30
 * @Version 1.0
 */
public class OperationDiv extends Operation{
	@Override
	public double getResult() {
		return getNumber1() / getNumber2();
	}
}
