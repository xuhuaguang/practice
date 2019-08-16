package com.rxlm.practice.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;

/**
 * @ClassName: FutureTaskThread
 * @Description:
 * @Author: xz
 * @CreateDate: 2019/7/30 11:33
 * @Version: 1.0
 */
public class FutureTaskThread {
    //FutureTask在高并发环境下确保任务只执行一次
    /*private ConcurrentHashMap<String,FutureTask<Connection>> connectionPool = new ConcurrentHashMap<String,FutureTask<Connection>>();
    public Connection getConnection(String key) throws Exception{
        FutureTask<Connection> connectionTask = connectionPool.get(key);
        if (connectionTask != null) {
            return connectionTask.get();
        } else {
            Callable<Connection> callable = new Callable<Connection>() {
                @Override
                public Connection call() throws Exception {
                    return createConnection();
                }
            };
            FutureTask<Connection> newTask = new FutureTask<Connection>(callable);
            connectionTask  = connectionPool.computeIfAbsent(key,newTask);
            if (null == connectionTask) {
                connectionTask = newTask;
                connectionTask.run();
            }
            return connectionTask.get();
        }
    }
*/
//创建Connection


//    private Connection createConnection() {
//        return null;
//    }
}
