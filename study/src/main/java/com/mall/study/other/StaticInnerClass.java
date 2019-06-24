package com.mall.study.other;
public class StaticInnerClass {
	public static void main(String[] args) {
		StaticInnerClass t3 = new StaticInnerClass("1");
		final Object object = t3;
		System.out.println(object.toString());
		t3.setName("2");
		System.out.println(object.toString());
		// 静态内部类不依赖外部内被实例化
		TInner tInner = new TInner();
		String string = "";
	}
	
	
	private String name;


	private StaticInnerClass() {
		super();
	}


	private StaticInnerClass(String name) {
		super();
		this.name = name;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "T3 [name=" + name + "]";
	}
	
	static class TInner{
		
	}
}

