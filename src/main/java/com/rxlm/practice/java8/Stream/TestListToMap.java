package com.rxlm.practice.java8.Stream;

import com.rxlm.practice.java8.bean.Orange;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @ClassName: TestListToMap
 * @Description:
 * @Author: xz
 * @CreateDate: 2019/5/31 22:42
 * @Version: 1.0
 */
public class TestListToMap {
    public static void main(String[] args) {
        //存放Orange对象集合
        List<Orange> orangeList = new ArrayList<>();
        Orange orange1 =  new Orange(1,"苹果1",new BigDecimal("3.25"),10);
        Orange orange2 = new Orange(1,"苹果2",new BigDecimal("1.35"),20);
        Orange orange3 =  new Orange(2,"香蕉",new BigDecimal("2.89"),30);
        Orange orange4 =  new Orange(3,"荔枝",new BigDecimal("9.99"),40);
        orangeList.add(orange1);
        orangeList.add(orange2);
        orangeList.add(orange3);
        orangeList.add(orange4);
        //java8ListToMap(orangeList);
        //getIdNameMap(orangeList);
        getNameOrangeMap(orangeList);
    }

    /**
     * List -> Map
     * 需要注意的是：
     * toMap 如果集合对象有重复的key，会报错Duplicate key ....
     *  orange1,orange2的id都为1。
     *  可以用 (k1,k2)->k1 来设置，如果有重复的key,则保留key1,舍弃key2
     *  key为对象的id,value为对象
     */
    public static void java8ListToMap(List<Orange> orangeList) {
        Map<Integer, Orange> collect = orangeList.stream().collect(Collectors.toMap(Orange::getId, a -> a,(k1,k2)->k1));
        Map<Integer, Orange> collect1 = orangeList.stream().collect(Collectors.toMap(Orange::getId, Function.identity(),(k1, k2)->k1));
        collect.forEach((k,v)->{
            System.out.println(k+"------"+v.toString());
        });
    }

    /**
     *key为对象的id,value为对象的名称
     * @param orangeList
     * @return
     */
    public static void  getIdNameMap(List<Orange> orangeList) {
        Map<Integer, String> collect = orangeList.stream().collect(Collectors.toMap(Orange::getId, Orange::getName,(key1, key2) -> key2));
        collect.forEach((k,v)->{
            System.out.println(k+"------"+v);
        });
    }

    //指定具体收集的map
    //比如我想获取LinkedHashMap
    public static void getNameOrangeMap(List<Orange> orangeList) {
        LinkedHashMap<Integer, Orange> collect = orangeList.stream().collect(Collectors.toMap(Orange::getId, Function.identity(), (k1, k2) -> k2, LinkedHashMap::new));
        collect.forEach((k,v)->{
            System.out.println(k+"------"+v.toString());
        });
    }
}
