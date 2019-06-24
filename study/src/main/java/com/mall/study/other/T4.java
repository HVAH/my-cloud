package com.mall.study.other;
import java.io.UnsupportedEncodingException;

public class T4 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		long round = Math.round(11.5);
		long rint = Math.round(-11.5);
		System.out.println(round + "\r\n" + rint);
		
		////////////////////////
		String str = "fasjkfnaskj";
		String string =new String(str.getBytes("ISO-8859-1"), "GBK");
		System.out.println(str + "\r\n" + string);
		
		
		short s1 = 1;
		s1 += 1;
		System.out.println();
	}
}


abstract class A {
	 abstract void a();
}
