package com.rxlm.practice.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName: Compare
 * @Description:
 *      Lambda表达式可以分为两部分：
 *      左侧：指定了Lambda表达式需要的所有参数
 *      右侧：指定了Lambda体，即lambda表达式要执行的功能
 * @Author: xz
 * @CreateDate: 2019/4/12 11:31
 * @Version: 1.0
 */
public class Compare {

    public static void main(String[] args) {
        compareTo();
    }

    /**
     * 一般比较方法
     */
    public static void compareTo() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        for (String name : names) {
            System.out.println(name);
        }
    }

    /**
     * lambda形式
     */
    public static void compare2() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names,(String a, String b)->{
            return b.compareTo(a);
        });
        //简洁版1
        Collections.sort(names,(String a, String b)->b.compareTo(a));

        Collections.sort(names,(a,b)->b.compareTo(a));
    }
}
