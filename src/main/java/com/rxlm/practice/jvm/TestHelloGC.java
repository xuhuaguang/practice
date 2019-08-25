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
     * -Xms初始堆内存大小，一般为初始的1/64大小
     * -Xmx最大堆内存大小，一般默认为1/4。属于xx方式
     *
     * -Xss 栈空间  等价于-XX:ThreadStackSize
     *
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
     * 堆存储  栈运行
     *
     * 经典JVM配置
     * -Xms128m -Xmx4096m -Xss1024k -XX:MetaspaceSize=512m -XX:+PrintCommandLineFlags -XX:+PrintGCDetails -XX:+UseSerialGC
     *
     */
    public static void main(String[] args) {
        //获取初始内存大小Java方法 -Xms
        long totalMemory = Runtime.getRuntime().totalMemory();
        //Java虚拟机试图使用的最大内存量
        long maxMemory = Runtime.getRuntime().maxMemory();

        //获取
        System.out.println("---------------------");
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
