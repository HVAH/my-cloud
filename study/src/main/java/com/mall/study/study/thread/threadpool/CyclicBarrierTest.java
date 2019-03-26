package com.mall.study.study.thread.threadpool;

import java.io.Writer;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Description
 * @Author Jiang
 * @Date 2019/3/1 14:01
 * @Version 1.0
 **/
public class CyclicBarrierTest {
    public static void main(String[] args) {
        int n = 4;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(n, new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程" + Thread.currentThread().getName() + " 干其他事情");
            }
        });
        for (int i = 0; i < n; i++) {
            if (i < n - 1) {
                new Writer(cyclicBarrier).start();
            } else {
                try {
                    Thread.sleep(5000);
                    new Writer(cyclicBarrier).start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("所有线程写入完毕，继续处理其他任务...");

        for (int i = 0; i < n; i++) {
            if (i < n - 1) {
                new Writer(cyclicBarrier).start();
            } else {
                try {
                    Thread.sleep(5000);
                    new Writer(cyclicBarrier).start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Writer extends Thread {
        private CyclicBarrier cyclicBarrier;

        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据...");
            try {
                Thread.sleep(5000);      //以睡眠来模拟写入数据操作
                System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");
                try {
                    cyclicBarrier.await(2000, TimeUnit.MILLISECONDS);
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
