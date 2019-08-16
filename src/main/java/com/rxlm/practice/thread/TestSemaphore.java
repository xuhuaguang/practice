package com.rxlm.practice.thread;

import java.util.concurrent.Semaphore;

/**
 * Semaphore就是一个信号量，它的作用是限制某段代码块的并发数。
 * Semaphore有一个构造函数，可以传入一个int型整数n，表示某段代码最多只有n个线程可以访问，
 * 如果超出了n，那么请等待，等到某个线程执行完毕这段代码块，下一个线程再进入。
 * 由此可以看出如果Semaphore构造函数中传入的int型整数n=1，相当于变成了一个synchronized了。
 */
public class TestSemaphore {

    /**
     * acquire()用来获取一个许可，若无许可能够获得，则会一直等待，直到获得许可。
     * release()用来释放许可。注意，在释放许可之前，必须先获获得许可。
     * @param args
     */
    public static void main(String[] args) {
        int n = 8;//工人数
        Semaphore semaphore = new Semaphore(5);//集齐数目
        for (int i = 0; i < n; i++) {
            new Worker(i,semaphore).start();
        }
    }

    static class Worker extends Thread{
        private int num;
        private Semaphore semaphore;

        public Worker(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人" + this.num + "占用一个机器在生产...");
                Thread.sleep(2000);
                System.out.println("工人" + this.num + "释放机器");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
