package com.mall.study.designPattern.factory;

/**
 * @Description 乘法
 * @Author HuangJiang
 * @Date 2018/8/31 10:29
 * @Version 1.0
 */
public class OperationMul extends Operation{
	@Override
	public double getResult() {
		return getNumber1() * getNumber2();
	}
}
