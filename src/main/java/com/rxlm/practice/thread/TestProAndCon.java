package com.rxlm.practice.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: TestProAndCon
 * @Description:
 * @Author: xz
 * @CreateDate: 2019/8/24 22:23
 * @Version: 1.0
 */
public class TestProAndCon {

    static class Source {
        private volatile boolean FLAG = true;
        private AtomicInteger atomicInteger = new AtomicInteger();
        private BlockingQueue<String> blockingQueue = null;

        public Source(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
            System.out.println(Thread.currentThread().getName());
        }

        //生产线程
        public void myProd() throws Exception {
            String result = null;
            boolean reValue;
            while (FLAG) {
                result = atomicInteger.incrementAndGet() + "";
                reValue = blockingQueue.offer(result, 2L, TimeUnit.SECONDS);
                if (reValue) {
                    System.out.println(Thread.currentThread().getName() + "\t 插入队列" + result + "成功");
                } else {
                    System.out.println(Thread.currentThread().getName() + "\t 插入队列" + result + "失败");
                }
                Thread.sleep(1000);
            }
            System.out.println(Thread.currentThread().getName() + "\t 大boss叫停了，表示FLAG = false,生产动作结束");
        }

        //消费线程
        public void myConsumer() throws Exception {
            String poll = null;
            while (FLAG) {
                poll = blockingQueue.poll(2L, TimeUnit.SECONDS);
                if (null == poll || "".equalsIgnoreCase(poll)) {
                    FLAG = false;
                    System.out.println(Thread.currentThread().getName()+"\t 超过2秒钟没有取到蛋糕，消费退出");
                    System.out.println();
                    System.out.println();
                    return;
                }
                System.out.println(Thread.currentThread().getName()+"\t 消费队列"+poll +"成功");
            }
        }

        //停止消费
        public void stop () {
            this.FLAG = false;
        }

        public static void main(String[] args) {
            Source source = new Source(new ArrayBlockingQueue<>(10));
            //线程生产
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 生产线程启动");
                try {
                    source.myProd();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },"prod").start();

            //线程消费
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 消费线程启动");
                try {
                    source.myConsumer();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },"consumer").start();


            try {
                Thread.sleep(5000);
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("5秒钟时间到，大老板main线程叫停，活动结束");

                //停止线程
                source.stop();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}