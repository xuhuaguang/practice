package com.rxlm.practice.java8.interfaces;

/**
 * @ClassName: Converter
 * @Description:
 * @Author: xz
 * @CreateDate: 2019/4/17 10:24
 * @Version: 1.0
 */
@FunctionalInterface
public interface Converter<F,T> {
    T convert(F from);
}
