package com.rxlm.practice.java8.future;

import java.util.concurrent.*;

/**
 * @ClassName: ExecutorService
 * @Description:
 * @Author: xz
 * @CreateDate: 2019/6/30 14:47
 * @Version: 1.0
 */
public class ExecutorServiceClass {

    public static void future() {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Double> future = executor.submit(new Callable<Double>() {public Double call() {
            //return doSomeLongComputation();
            return null;
        }});
        try {
            //doSomethingElse();
            Double result = future.get(1, TimeUnit.SECONDS);
        }  catch (ExecutionException ee) {
            // 计算抛出一个异常 阻塞，无法得到结
        } catch (InterruptedException ie) {
            // 当前线程在等待过程中被中断 待1秒钟之后退出
        } catch (TimeoutException te) {
            // 在Future对象完成之前超过已过期
        }
    }
}
