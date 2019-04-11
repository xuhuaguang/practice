package com.rxlm.practice.java8.interfaces;

/**
 * @ClassName: Formula
 * @Description:
 * @Author: xz
 * @CreateDate: 2019/4/11 17:43
 * @Version: 1.0
 */
public interface Formula {
    double calculate(int a);
    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}

