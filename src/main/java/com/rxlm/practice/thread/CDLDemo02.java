package com.rxlm.practice.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName: CDLDemo02
 * @Description:
 * @Author: xz
 * @CreateDate: 2019/8/19 11:48
 * @Version: 1.0
 */
public class CDLDemo02 {
    private static final Integer N = 100;

    public static void main(String[] args) throws Exception{
        CountDownLatch startSignal = new CountDownLatch(1); //启动信号
        CountDownLatch doneSignal = new CountDownLatch(N); //工作信号
        //创建N个线程
        for (int i = 0; i < N; ++i)
            new Thread(new Worker(startSignal, doneSignal)).start();

        System.out.println("主线程=>countDown前");
        //"启动信号"触发开闸，因为只有一个闸，停止await()方法的阻塞。
        startSignal.countDown();
        System.out.println("主线程=>await前");
        //"工作信号"等待其对应的所有闸门(即N个闸门都开闸)，才会停止await()方法的阻塞。
        doneSignal.await();
        System.out.println("主线程=>await后");
    }

   static class Worker implements Runnable {
        private final CountDownLatch startSignal;
        private final CountDownLatch doneSignal;

        Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
        }

        public void run() {
            try {
                //"启动信号"在这里阻塞，等待启动信号的所有闸门都开了(即触发对应的次数的countDown)
                System.out.println("000000");
                startSignal.await();
                doWork();
                //"工作信号"在对应的子线程执行countDown()开一个闸门，等到所有子线程执行完就会开完N个闸门，这时候"工作信号"的await()就不会继续阻塞
                doneSignal.countDown();
            } catch (Exception ex) {
            } // return;
        }

        private void doWork() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}