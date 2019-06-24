package com.mall.study.other;
import java.util.concurrent.Callable;

public class Testclass {
	public static void main(String[] args) {
		int a = 1 ;
		int b = 100;
		Tickets t = new Tickets(a,b);
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		Thread t3 = new Thread(t);
		Thread t4 = new Thread(t);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}


class To implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		
		return null;
	}
	
}
