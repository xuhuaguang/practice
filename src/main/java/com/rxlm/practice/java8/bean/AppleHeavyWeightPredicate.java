package com.rxlm.practice.java8.bean;

import com.rxlm.practice.java8.interfaces.ApplePredicate;

/**
 * @ClassName: AppleHeavyWeightPredicate
 * @Description:
 * @Author: xz
 * @CreateDate: 2019/5/25 9:57
 * @Version: 1.0
 */
public class AppleHeavyWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
