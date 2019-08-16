package com.rxlm.practice.java8.bean;

import com.rxlm.practice.java8.interfaces.ApplePredicate;

/**
 * @ClassName: AppleGreenColorPredicate
 * @Description:
 * @Author: xz
 * @CreateDate: 2019/5/25 9:58
 * @Version: 1.0
 */
public class AppleGreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
