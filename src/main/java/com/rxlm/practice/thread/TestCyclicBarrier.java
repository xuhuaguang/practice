package com.rxlm.practice.thread;

import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName: TestCyclicBarrier
 * @Description: 其他人理解：CD：司机在等人坐满了才开车，阻塞主体是外部线程。 CB：人在等其他人来了再上车，阻塞主体是多个线程
 * @Author: xz
 * @CreateDate: 2019/8/19 10:16
 * @Version: 1.0
 */
public class TestCyclicBarrier {
    public static void main(String[] args) throws InterruptedException {
        /**
         * 参数parties指让多少个线程或者任务等待至barrier状态；
         * 参数barrierAction为当这些线程都达到barrier状态时会执行的内容。
         */
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            //主线程执行
            @Override
            public void run() {
                System.out.println("线程组执行结束");
            }
        });
        for (int i = 0; i < 5; i++) {
            new Thread(new readNum(i, cyclicBarrier)).start();
        }
        System.out.println("main function is finished.");
    }

    static class readNum implements Runnable {
        private int id;
        private CyclicBarrier cyc;

        public readNum(int id, CyclicBarrier cyc) {
            this.id = id;
            this.cyc = cyc;
        }

        @Override
        public void run() {
            synchronized (this) {
                System.out.println("id:" + id);
                try {
                    cyc.await();
                    System.out.println("线程组任务" + id + "结束，其他任务继续");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
