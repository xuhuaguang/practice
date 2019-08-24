package com.rxlm.practice.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: Condition
 * @Description:
 * @Author: xz
 * @CreateDate: 2019/8/24 10:07
 * @Version: 1.0
 */
public class TestCondition {

    static class Source{
        private int num = 1;
        private Lock lock = new ReentrantLock();
        private Condition c1 = lock.newCondition();
        private Condition c2 = lock.newCondition();
        private Condition c3 = lock.newCondition();

        public void print5 () {
            lock.lock();
            try {
                //判断  默认值绝对不走这，因为目前默认值为1
                while (num != 1) {
                    c1.await();
                }
                for (int i = 1; i <= 5; i++) {
                    System.out.println(Thread.currentThread().getName()+"\t"+ i);
                }
                num = 2;
                c2.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void print10 () {
            lock.lock();
            try {
                //判断  默认值绝对不走这，因为目前默认值为0
                while (num != 2) {
                    c2.await();
                }
                for (int i = 1; i <= 10; i++) {
                    System.out.println(Thread.currentThread().getName()+"\t"+ i);
                }
                num = 3;
                c3.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void print15 () {
            lock.lock();
            try {
                //判断  默认值绝对不走这，因为目前默认值为0
                while (num != 3) {
                    c3.await();
                }
                for (int i = 1; i <= 15; i++) {
                    System.out.println(Thread.currentThread().getName()+"\t"+ i);
                }
                num = 1;
                c1.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * 多线程之间按顺序调用，实现A->B->C 三个线程启动，要求如下：
     * AA打印5次  BB打印10次  CC打印15次
     *紧跟着
     * AA打印5次  BB打印10次  CC打印15次
     * 循环10次
     * @param args
     */
    public static void main(String[] args) {
        Source souce = new Source();
        new Thread(()->{
            for (int i = 0; i < 10;i++) {
                souce.print5();
            }
        },"AAA").start();

        new Thread(()->{
            for (int i = 0; i < 10;i++) {
                souce.print10();
            }
        },"BBB").start();

        new Thread(()->{
            for (int i = 0; i < 10;i++) {
                souce.print15();
            }
        },"CCC").start();
    }
}
