package com.rxlm.practice.java8.bean;

import com.rxlm.practice.java8.interfaces.ApplePredicate;

/**
 * @ClassName: AppleRedAndHeavyPredicate
 * @Description:
 * @Author: xz
 * @CreateDate: 2019/5/25 10:13
 * @Version: 1.0
 */
public class AppleRedAndHeavyPredicate  implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return "red".equals(apple.getColor())
                && apple.getWeight() > 150;
    }
}
