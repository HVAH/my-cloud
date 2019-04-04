package com.mall.study.study.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @Description
 * @Author Jiang
 * @Date 2019/2/25 13:53
 * @Version 1.0
 **/
public class CountDownLatcehTest {

    public static void main(String[] args) {
        System.out.println("\\xF0\\x9F\\x92\\x8B");
        final CountDownLatch latch = new CountDownLatch(2);
        new Thread(() -> {
                try {
                    System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }).start();

        new Thread(() -> {
            try {
                System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                Thread.sleep(3000);
                System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

        try {
            System.out.println("等待2个子线程执行完毕...");
            latch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
