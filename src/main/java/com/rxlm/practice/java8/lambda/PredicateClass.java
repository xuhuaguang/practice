package com.rxlm.practice.java8.lambda;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * @ClassName: Predicate
 * @Description:
 * @Author: xz
 * @CreateDate: 2019/4/17 17:09
 * @Version: 1.0
 */
public class PredicateClass {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        Predicate<String> predicate = (s)->s.length() > 0;
        boolean foo = predicate.test("foo");
        System.out.println(foo);

        Predicate<Boolean> notNull = Objects::nonNull;

    }

}
