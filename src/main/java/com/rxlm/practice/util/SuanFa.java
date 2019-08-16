package com.rxlm.practice.util;

import com.rxlm.practice.java8.bean.Rule;

import java.util.*;
import java.util.function.Predicate;

/**
 * @ClassName: SuanFa
 * @Description:
 * @Author: xz
 * @CreateDate: 2019/6/27 15:59
 * @Version: 1.0
 */
public class SuanFa {
    public static void main(String[] args) {
        /*int i = countPrimeSetBits(6, 10);
        System.out.println(i);*/
        getData("","");
    }

    public static int countPrimeSetBits(int L, int R) {
        //将满足条件的0到32之间的质数存储在isPrimeNumber数组中
        int[] isPrimeNumber = new int[]{0,0,1,1,0,1,0,1,0,0,0,1,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,0,0,1,0,1,0};
        int res = 0;

        for(int i = L; i <= R; i++){
            //调用countBit方法将第I个数的计算置位位数返回
            res += isPrimeNumber[countBit(i)];
        }
        return res;
    }

    private static int countBit(int num){
        int res = 0;
        while(num != 0){
            res += num & 1;
            num = num >> 1;
        }

        return res;
    }

    public static void getData(String sourceData,String ruleData) {
        //把字符串解析为集合
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        List<Rule> rulelist = new ArrayList<>();
        Rule rule = new Rule();
        rule.setId(1);
        String[] args = {"a","b"};
        rule.setArgs(args);
        rulelist.add(rule);

        Rule rule2 = new Rule();
        rule2.setId(2);
        String[] args2 = {"a","c"};
        rule2.setArgs(args2);
        rulelist.add(rule2);

        //传入一个a\b\c的播表，分成ab、bc和ca三组。
        //然后计算a、b和c在规则里的数值(一个数组形式)例如a在上述里规则值是[1,2]  b是[1] c是[2]。
        //然后一次取交集，看是否有值，有表示不符合规则要求
        Map<String,List<Integer>> map = new HashMap<>();
        for (String l : list) {
            List<Integer> finalLi = new ArrayList<>();;
            rulelist.stream().forEach(r -> {
                boolean b = isContain(r.getArgs(), l);
                if (b) {
                    finalLi.add(r.getId());
                }
            });
            map.put(l, finalLi);
        }

        System.out.println(map);
        for (Map.Entry<String, List<Integer>> s : map.entrySet()) {
            System.out.println(s.getKey());
        }
    }

    /**
     *
     * @param arr 字符串数组
     * @param targetValue 被比较的字符串
     * @return
     */
    public static boolean isContain(String[] arr, String targetValue) {
        return  Arrays.stream(arr).anyMatch(
                Predicate.isEqual(targetValue)
        );
    }


}
