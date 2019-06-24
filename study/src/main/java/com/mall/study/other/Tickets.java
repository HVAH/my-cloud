package com.mall.study.other;


public class Tickets implements Runnable {
	int a;
	int b;

	public Tickets(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	public void run() {
		add();
	}

	private void add() {
		if (a > b) {
			int temp = a;
			a = b;
			b = temp;
		}
		int count = 0;
		while (true) {
			synchronized (this) {
				if (a < b) {
					System.out.println(Thread.currentThread().getName()
							+ "正在执行第" + a + "次运算");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					count = count + a;
					a++;
				} else {
					System.out.println("a+b=" + count);
					break;
				}
			}
		}
	}
}