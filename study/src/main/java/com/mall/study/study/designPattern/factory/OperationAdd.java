package com.mall.study.study.designPattern.factory;

/**
 * @Description TODO
 * @Author HuangJiang
 * @Date 2018/8/31 9:31
 * @Version 1.0
 */
public class OperationAdd extends Operation{
	@Override
	public double getResult() {
		return getNumber1() + getNumber2();
	}
}
