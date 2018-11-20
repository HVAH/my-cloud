package com.mall.study.study.other;

public class T6 {
	public static void main(String[] args) {
		Integer a = 1000;
		int b = 1000;
		Integer c = 1000;
		System.out.println(a.equals(b));
		System.out.println(a == c);
		
		
		
		System.out.println("3.0".compareToIgnoreCase("3.2.1"));
		
		
		System.out.println("a" == new String("a"));
	}
}


abstract class AA {
	private int a;
	
	abstract void say();
}