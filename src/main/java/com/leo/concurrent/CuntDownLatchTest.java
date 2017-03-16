package com.leo.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch使用例子
 * CountDownLatch可以使用await方法锁着当前线程，直到调用countDown方法的次数到达构造方法中传入的参数
 * Created on 2017/3/16 下午5:09
 * leo linxiaotao1993@vip.qq.com
 */
public class CuntDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            new Thread(new Worker(startSignal, doneSignal, String.valueOf(i) + "线程")).start();
        }
        System.out.println("开始线程调用countDown前");
        startSignal.countDown();
        System.out.println("开始线程调用countDown后");
        doneSignal.await();
        System.out.println("donwSignal等待之后");

    }

    private static class Worker implements Runnable {

        private final CountDownLatch startSignal;
        private final CountDownLatch doneSignal;
        private final String thradName;

        Worker(CountDownLatch startSignal, CountDownLatch doneSignal, String threadName) {
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
            this.thradName = threadName;
        }

        @Override
        public void run() {
            try {
                startSignal.await();
                System.out.println(String.format("当前进程:%s", thradName));
                doneSignal.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
