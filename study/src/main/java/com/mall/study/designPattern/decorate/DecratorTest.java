package com.mall.study.designPattern.decorate;

/**
 * @Description TODO
 * @Author HuangJiang
 * @Date 2018/8/31 16:17
 * @Version 1.0
 */
public class DecratorTest {
	public static void main(String[]args){
		ConcretComponent c = new ConcretComponent();
		ConcreteDecoratorA d1 = new ConcreteDecoratorA();
		ConcreteDecoratorB d2 = new ConcreteDecoratorB();

		d1.setComponent(c);
		d2.setComponent(d1);
		d2.operation();
	}
}
