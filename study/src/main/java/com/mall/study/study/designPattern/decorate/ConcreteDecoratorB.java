package com.mall.study.study.designPattern.decorate;

/**
 * @Description TODO
 * @Author HuangJiang
 * @Date 2018/8/31 16:14
 * @Version 1.0
 */
public class ConcreteDecoratorB extends Decrator {

	private void addedBehavior() {
		System.out.println("具体装饰对象B的特有方法");
	}

	@Override
	public void operation() {
		super.operation();
		addedBehavior();
		System.out.println("具体装饰对象B的操作");
	}
}
