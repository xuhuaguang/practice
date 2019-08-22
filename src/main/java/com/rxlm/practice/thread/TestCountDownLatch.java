package com.rxlm.practice.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName: TestCountDownLatch
 * @Description:
 * @Author: xz
 * @CreateDate: 2019/8/16 10:49
 * @Version: 1.0
 */
public class TestCountDownLatch {
    public static void main(String[] args) throws InterruptedException{
        CountDownLatch latch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(new readNum(i,latch)).start();
        }
        latch.await();
        System.out.println("线程结束走这-----");
    }

    static class readNum implements Runnable{
        private int id;
        private CountDownLatch latch;

        public readNum(int id, CountDownLatch latch) {
            this.id = id;
            this.latch = latch;
        }

        @Override
        public void run() {
            synchronized (latch) {
                System.out.println("id:"+id);
                latch.countDown();
                System.out.println("线程组任务"+id+"结束，其他任务继续");
            }
        }
    }
}
