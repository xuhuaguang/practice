package com.rxlm.practice.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * cas底层核心 unsafe类。它是一条CPU并发原语。
 * unsafe类中的所有方法都是volatile修饰，存在sun.misc包中
 *
 */
public class TestCAS {
    //cas 比较并交换
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2019)+"\t"+atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 2018)+"\t"+atomicInteger.get());
    }
}
