package com.mall.study.thread;

import com.google.common.collect.Maps;

import java.util.concurrent.*;

/**
 * @Description
 * @Author Jiang
 * @Date 2019/3/1 14:01
 * @Version 1.0
 **/
public class CyclicBarrierTest {
    public static void main(String[] args) {
        final int N = 10;
        Thread[] allSoldier = new Thread[N];
        boolean flag = false;
        CyclicBarrier cyclic = new CyclicBarrier(N,new BarrierRun(flag,N));
        //设置屏障点，主要是为了执行这个方法
        System.out.println("集合队伍!");
        for(int i = 0;i < N;i++){
            allSoldier[i] =new Thread(new Soldier("士兵"+i, cyclic));
            allSoldier[i].start();
        }


        System.out.println("=============================================================");



        new CyclicBarrierUseService().calculate();
    }

}


class Soldier implements Runnable {
    private String soldierName;
    private final CyclicBarrier cyclic;

    public Soldier(String soldierName, CyclicBarrier cyclic) {
        this.soldierName = soldierName;
        this.cyclic = cyclic;
    }

    @Override
    public void run() {
        try {
            System.out.println("当前线程" + Thread.currentThread().getName() + ": " + soldierName +" 报道！");
            //等待其他士兵到齐
            cyclic.await();
            doWork();
            //等待其他士兵完成工作
            cyclic.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }


    void doWork(){
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("当前线程" + Thread.currentThread().getName() + ": " + soldierName+" :任务完成");
    }
}

class BarrierRun implements Runnable{
    boolean flag;
    int N;
    public BarrierRun(boolean flag,int N){
        this.flag = flag;
        this.N = N;
    }
    @Override
    public void run() {
        if(flag){
            System.out.println("当前线程" + Thread.currentThread().getName() + ": " + "司令:[士兵"+N+"个，任务完成！]");
        }else{
            System.out.println("当前线程" + Thread.currentThread().getName() + ": " + "司令:[士兵"+N+"个，集合完毕！]");
            flag = true;
        }
    }
}


class  CyclicBarrierUseService implements Runnable {
    int n = 4;
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(n, this);

    private Executor executor = Executors.newFixedThreadPool(n);

    private ConcurrentMap<String, Integer> count = Maps.newConcurrentMap();

    @Override
    public void run() {
        int result = 0;
        for (String s : count.keySet()) {
            result += count.get(s);
        }
        count.put(Thread.currentThread().getName(), result);
        System.out.println(count);
    }

    public void calculate() {
        for (int i = 0; i < n; i++) {
            executor.execute(() -> {
                count.put(Thread.currentThread().getName(), 10);
                System.out.println(Thread.currentThread().getName() + "is waiting");
                try {
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + "is working");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}


