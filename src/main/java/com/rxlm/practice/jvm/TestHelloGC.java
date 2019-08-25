package com.rxlm.practice.jvm;

/**
 * @ClassName: TestHelloGC
 * @Description:
 * @Author: xz
 * @CreateDate: 2019/8/25 17:08
 * @Version: 1.0
 */
public class TestHelloGC {
    /**
     * jps 查看进程数
     * jinfo -flag  具体参数  进程数
     * jinfo -flags 进程数
     *
     * boolean类型  双xx  +代表开启  - 关闭
     * kv类型
     *
     * -Xms初始堆内存大小  -Xmx最大堆内存大小。1/64 属于xx方式
     *
     * 查找JVM初始化默认参数的命令：
     * java -XX:+PrintFlagsInitial
     *
     * 查看修改更新
     * java -XX:+PrintFlagsFinal -version   :=代表修改以后的   =没有动过
     *
     * 打印命令参数
     * java -XX:+PrintCommandLineFlags -version
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("---------------------");
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
