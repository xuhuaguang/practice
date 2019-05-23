package com.rxlm.practice.java8.Stream;

import java.util.Arrays;
import java.util.List;
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
    }

    public static void list() {
        String string= "文学-小说-历史-言情-科幻-悬疑";
        List<String> list = Arrays.asList(string.split("-")).stream().map(s -> String.format(s.trim())).collect(Collectors.toList());
        for (String s : list) {
            System.out.println(s);
        }
    }
}
