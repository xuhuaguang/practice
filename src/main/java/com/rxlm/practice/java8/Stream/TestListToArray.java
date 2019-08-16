package com.rxlm.practice.java8.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName: TestListToArray
 * @Description:
 * @Author: xz
 * @CreateDate: 2019/5/31 22:23
 * @Version: 1.0
 */
public class TestListToArray {
    public static void main(String[] args) {
        arrayToList();
    }

    /**
     * 数组转集合
     */
    public static void arrayToList() {
        String[] arrays = new String[]{"a", "b", "c"};
        List<String> collect = Stream.of(arrays).collect(Collectors.toList());
        List<String> list = Arrays.asList(arrays);
        System.out.println(collect.size() +"--------"+list.size());
    }

    /**
     * 集合转数组
     */
    public static void listToArray() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        String[] strings = list.toArray(new String[list.size()]);

        String[] strings1 = list.stream().toArray(String[]::new);

    }
}
