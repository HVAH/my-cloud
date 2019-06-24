package com.mall.study.thread.threadpool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @Description 线程池学习
 * @Author HuangJiang
 * @Date 2018/9/4 18:21
 * @Version 1.0
 */
public class ThreadPoolExecutorTest {
	public static void main(String[]args){
		// 创建可缓存的线程池
//		 cachPool();

		// 创建一个可重用固定个数的线程池
		//fixedPool();

		// 创建定长线程池,支持定时及周期性任务执行
		schedulePool();




	}

	private static void schedulePool() {
		// 创建定长线程池,支持定时及周期性任务执行
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		scheduledThreadPool.schedule(new Runnable() {
			@Override
			public void run() {
				System.out.println("延迟一秒执行");
			}
		}, 1, TimeUnit.SECONDS);

		ScheduledFuture<?> scheduledFuture = scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "   延迟一秒执行,每三秒执行一次  " + Thread.currentThread().getName());
			}
		}, 1, 100, TimeUnit.MILLISECONDS);
	}

	private static void fixedPool() {
		// 获取当前cpu线程数
		int i1 = Runtime.getRuntime().availableProcessors();
		System.out.println(i1);
		// 创建一个可重用固定个数的线程池，以共享的无界队列方式来运行这些线程
		ExecutorService executorService = Executors.newFixedThreadPool(i1);
		for (int i = 0; i < 10; i++) {
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					// 打印正在执行的线程信息
					System.out.println(Thread.currentThread().getName() + " 正在执行");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}


	private static void cachPool() {
		// 创建可缓存的线程池, 先查看池中有没有之前创建的且处于空闲的线程,如果有就直接使用,没有则新建一个线程加入池中使用
		// 线程池大小无上限,当前任务执行时上一个任务已经执行完毕,线程会被复用,不会新创建线程,
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			try {
				// 模拟任务执行时间
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cachedThreadPool.execute(new Runnable() {
				@Override
				public void run() {
					// 打印正在执行的线程信息
					for (int j = 0; j < 1; j++) {
						System.out.println(Thread.currentThread().getName() + " 正在执行");
					}
				}
			});
		}
	}
}
