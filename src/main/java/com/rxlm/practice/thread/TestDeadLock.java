package com.rxlm.practice.thread;

/**
 * @ClassName: TestDeadLock
 * @Description: 死锁编码以及定位分析
 * @Author: xz
 * @CreateDate: 2019/8/25 15:53
 * @Version: 1.0
 */
public class TestDeadLock {

    //线程操作资源类
    static class Source implements Runnable{

        private String lockA;
        private String lockB;

        public Source(String lockA, String lockB) {
            this.lockA = lockA;
            this.lockB = lockB;
        }

        @Override
        public void run() {
            synchronized (lockA) {
                System.out.println(Thread.currentThread().getName()+"\t我正在持有:"+lockA +"\t 正在尝试获取:"+lockB);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockB) {
                    System.out.println(Thread.currentThread().getName()+"\t我正在持有:"+lockB +"\t 正在尝试获取:"+lockA);
                }
            }
        }
    }

    /**
     * 排查死锁方式：
     * windows下  1.jps 通过jps命令定位进程号
     *            2.jstack命令找到死锁查看
     * @param args
     */
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new Source(lockA,lockB),"AAA").start();
        new Thread(new Source(lockB,lockA),"BBB").start();
    }
}
