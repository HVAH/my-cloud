package com.mall.study.study.string;

import java.lang.ref.PhantomReference;
import java.lang.ref.WeakReference;

/**
 * @description: 
 * @author: huangjiang  2018年6月11日 上午9:26:58
 */
public class T1 {
	public static void main(String[] args) {
		String string = "abcdefg";
		System.out.println(reverse(string));
		
		WeakReference<String> res = new WeakReference<String>(string);
		string = null;
		System.out.println(res.isEnqueued());
		Object object = new Object();
		PhantomReference<Object> res2 = new PhantomReference<Object>(object, null);
		object = null;
		Object object2 = res2.get();
		System.out.println();
	}
	
	
	public static String reverse(String originStr) {
		if(originStr == null || originStr.length() <= 1)

			return originStr;

		return reverse(originStr.substring(1)) + originStr.charAt(0);
	}
}
