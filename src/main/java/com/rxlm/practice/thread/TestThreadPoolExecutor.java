package com.rxlm.practice.thread;

import java.util.concurrent.*;

/**
 * @ClassName: TestThreadPoolExecutor
 * @Description:
 * @Author: xz
 * @CreateDate: 2019/8/25 12:05
 * @Version: 1.0
 */
public class TestThreadPoolExecutor {

    public static void main(String[] args) {
        //此三种方式，阿里强制不让使用，因为newFixedThreadPool和newSingleThreadExecutor底层阻塞队列用的是LinkedBlockingQueue,
        //它虽然是有界的，但范围为Integer.MAX_VALUE,跟无界没有什么区别。
        //newCachedThreadPool底层的最大线程数Integer.MAX_VALUE
        //ExecutorService threadPool = Executors.newFixedThreadPool(5);
        //ExecutorService threadPool = Executors.newCachedThreadPool();
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();

        //阿里推荐的
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        //cpu核数获取
        System.out.println(Runtime.getRuntime().availableProcessors());
        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t办理业务");
                });
                Thread.sleep(200);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
