package com.rxlm.practice.java8.Stream;

import com.rxlm.practice.java8.bean.Dish;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName: TestChapter4
 * @Description: Java8编程之第四章流的介绍
 * @Author: xz
 * @CreateDate: 2019/5/26 13:31
 * @Version: 1.0
 */
public class TestChapter4 {

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH) );

        java8before(menu);
        System.out.println("-------------------------");
        java8list(menu);
        System.out.println("-------------------------");
        java8map(menu);
        System.out.println("-----------");
        java8beanToString(menu);
    }

    /**
     * 选取卡路里小于400并且排序然后获取菜肴名称集合
     * @param menu
     */
    public static void java8before(List<Dish> menu) {
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(),o2.getCalories());
            }
        });

        List<String> lowCaloricDishesName = new ArrayList<>();
        for (Dish d : lowCaloricDishes) {
            lowCaloricDishesName.add(d.getName());
        }
        for (String s : lowCaloricDishesName) {
            System.out.println(s);
        }
    }

    /*选取卡路里小于400并且排序然后获取菜肴名称集合*/
    public static void java8list(List<Dish> menu) {
        //筛选热量低的菜肴
        //filter的结果被传给了sorted方法，再传给map方法，最后传给collect方法。
        List<String> collect =  menu.stream().
                                //选出400卡路里以下的菜肴
                                filter(dish -> dish.getCalories() < 400).
                                //按照卡路里排序
                                sorted(Comparator.comparing(Dish::getCalories)).
                                //提取菜肴 里排序的名称
                                map(Dish::getName).collect(Collectors.toList());

        collect.forEach(s -> System.out.println(s));
    }

    /*按照Map里面的类别对菜肴进行分组*/
    public static void java8map(List<Dish> menu) {
        //方法引用Dish::getType等价于d -> d.getType())
        //Map<Dish.Type, List<Dish>> collect = menu.stream().collect(Collectors.groupingBy(Dish::getType));
        Map<Dish.Type, List<Dish>> collect = menu.stream().collect(Collectors.groupingBy(d -> d.getType()));
        System.out.println(collect.toString());

    }

    /*将集合中Dish 对象name值以逗号方式隔开转为字符串*/
    public static void java8beanToString(List<Dish> menu) {
        String collect = menu.stream().map(Dish::getName).collect(Collectors.joining(","));
        System.out.println(collect);
    }
}
