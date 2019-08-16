package com.rxlm.practice.java8.Stream;

import com.rxlm.practice.java8.bean.Apple;
import com.rxlm.practice.java8.bean.AppleRedAndHeavyPredicate;
import com.rxlm.practice.java8.interfaces.ApplePredicate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName: TestParamHua
 * @Description:
 * @Author: xz
 * @CreateDate: 2019/5/25 9:59
 * @Version: 1.0
 */
public class TestParamHua {

    /**
     * Java8实战第二章测试
     * @param args
     */
    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.setColor("red");
        apple.setWeight(180);
        List<Apple> inventory = new ArrayList<>();
        inventory.add(apple);

        List<Apple> apples = filterApples(inventory, new AppleRedAndHeavyPredicate());
        System.out.println("size:"+apples.size());
        apples.forEach(app -> System.out.println(app.getColor()));

        inventory.sort(Comparator.comparing(Apple::getWeight));
    }
    //定义ApplePredicate接口作为参数，实际上接收的是其的实现类，然后重写ApplePredicate接口方法，来实现筛选的目的。
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
