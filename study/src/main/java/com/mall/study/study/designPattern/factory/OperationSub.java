package com.mall.study.study.designPattern.factory;

/**
 * @Description 减法
 * @Author HuangJiang
 * @Date 2018/8/31 10:26
 * @Version 1.0
 */
public class OperationSub extends Operation{
	@Override
	public double getResult() {
		return getNumber1() - getNumber2();
	}
}
