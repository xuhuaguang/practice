package com.rxlm.practice.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: TraditionalXF
 * @Description:
 * @Author: xz
 * @CreateDate: 2019/8/23 22:04
 * @Version: 1.0
 */
public class TraditionalXF {

   static class SourceData{
        private int num = 0;
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        public void increment () throws Exception{
            lock.lock();
            try {
                //判断
                while (num != 0) {
                    condition.await();
                }
                //干活
                num ++;
                System.out.println(Thread.currentThread().getName() + "\t" + num);
                //通知
                condition.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }
        }

        public void decrement () throws Exception{
            lock.lock();
            try {
                //判断
                while (num == 0) {
                    condition.await();
                }
                //干活
                num --;
                System.out.println(Thread.currentThread().getName() + "\t" + num);
                condition.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }
        }
    }
    public static void main(String[] args) {
       //线程  操作  资源类
        //判断  干活  通知
        SourceData sourceData = new SourceData();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    sourceData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    sourceData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();
    }
}
