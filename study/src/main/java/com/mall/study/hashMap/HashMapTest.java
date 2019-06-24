package com.mall.study.hashMap;
import java.util.HashMap;

/**
 * @description: HashMap多线程测试
 * @author: huangjiang  2018年6月7日 下午7:14:24
 */
public class HashMapTest {
	private static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(2,0.75f); 
	public static void main(String[] args) {
		map.put(5, 55);  
		
		new Thread("Thread1") {  
			public void run() {  
				map.put(7, 77);  
				System.out.println(map);  
			};  
		}.start();  
		new Thread("Thread2") {  
			public void run() {  
				map.put(3, 33);  
				System.out.println(map);  
			};  
		}.start();
		
		map.get(11);
		
	}
}


class Entry {
	
	Object key;
	Object value;
	
	private Entry(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
	
}
