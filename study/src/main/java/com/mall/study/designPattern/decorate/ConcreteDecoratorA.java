package com.mall.study.designPattern.decorate;

/**
 * @Description TODO
 * @Author HuangJiang
 * @Date 2018/8/31 16:12
 * @Version 1.0
 */
public class ConcreteDecoratorA extends Decrator {
	private String addedState;

	@Override
	public void operation() {
		super.operation();
		addedState = "new state";
		System.out.println("具体装饰对象A的操作");
	}
}
