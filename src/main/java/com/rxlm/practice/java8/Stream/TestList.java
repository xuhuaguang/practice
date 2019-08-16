package com.rxlm.practice.java8.Stream;

import com.rabbitmq.client.UnblockedCallback;
import com.rxlm.practice.java8.bean.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @ClassName: TestList
 * @Description:
 * @Author: xz
 * @CreateDate: 2019/5/23 15:40
 * @Version: 1.0
 */
public class TestList {
    public static void main(String[] args) {
        list();
        test2();
    }

    public static void list() {
        String string= "文学-小说-历史-言情-科幻-悬疑";
        List<String> list = Arrays.asList(string.split("-")).stream().map(s -> String.format(s.trim())).collect(Collectors.toList());
        for (String s : list) {
            System.out.println(s);
        }
        List<String> collect = Arrays.stream(string.split("-")).collect(Collectors.toList());
    }


    /**
     * Java实战之第三章的介绍测试
     */
    public static void test() {
        List<String> list = Arrays.asList("a", "b", "c", "d");
        list.sort((s1,s2)->s1.compareToIgnoreCase(s2));
        list.sort(String::compareToIgnoreCase);

        Supplier<Apple> c1 = () -> new Apple();
        Supplier<Apple> c2 = Apple::new;
    }

    public static void test2() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        String join = String.join(",", list);
        System.out.println(join);
        System.out.println("------------java8--------");
        String collect = list.stream().collect(Collectors.joining(","));
        System.out.println(collect);
    }

    public static List<Apple> map(List<Integer> list,
                                  Function<Integer, Apple> f){
        List<Apple> result = new ArrayList<>();
        for(Integer e: list){
            result.add(f.apply(e));
        }
        return result;
    }
}
