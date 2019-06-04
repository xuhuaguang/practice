package com.rxlm.practice.java8.interfaces;

import com.rxlm.practice.java8.bean.Apple;

/**
 * @ClassName: ApplePredicate
 * @Description:
 * @Author: xz
 * @CreateDate: 2019/5/25 9:55
 * @Version: 1.0
 */
public interface ApplePredicate {
    boolean test (Apple apple);
}
