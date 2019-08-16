package com.rxlm.practice.java8.Stream;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author: xz
 * @CreateDate: 2019/5/23 15:53
 * @Version: 1.0
 */
public class TestMap {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("2018", "法国");
        map.put("2014", "德国");
        map.put("2010", "西班牙");
        map.put("2006", "意大利");
        map.put("2002", "巴西");

        //test1(map);
        //test2(map);
        //test3(map);
        //test4(map);
        test5(map);
    }

    /**
     * 遍历Map的方式一
     * 通过Map.keySet遍历key和value
     */
    public static void test1(Map<String, Object> map) {
        System.out.println("---------------------Before JAVA8 ------------------------------");
        for (String key : map.keySet()) {
            System.out.println("key==>" + key + "，对应的value==>" + map.get(key));
        }

        System.out.println("---------------------JAVA8 ------------------------------");
        map.keySet().forEach(key->
                System.out.println("java8 key==>" + key + "，对应的value==>" + map.get(key))
        );
    }

    /**
     * 遍历Map第二种
     * 通过Map.values()遍历所有的value，但不能遍历key
     */
    public static void test2(Map<String, Object> map) {
        System.out.println("---------------------Before JAVA8 ------------------------------");
        for (Object value : map.values()) {
            System.out.println("map的value值==>" + value);
        }
        System.out.println("---------------------JAVA8 ------------------------------");
        map.values().forEach(System.out::println); // 等价于map.values().forEach(value -> System.out.println(value));
    }

    /**
     * 遍历Map第三种
     * 通过Map.entrySet使用Iterator遍历key和value
     */
    public static void test3(Map<String, Object> map) {

        System.out.println("---------------------Before JAVA8 ------------------------------");
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            System.out.println("key:value = " + entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("---------------------JAVA8 ------------------------------");
        map.entrySet().iterator().forEachRemaining(item -> System.out.println("key:value=" + item.getKey() + ":" + item.getValue()));
    }

    /**
     * 遍历Map第四种
     * 通过Map.entrySet遍历key和value，在大容量时推荐使用
     */
    public static void test4(Map<String, Object> map) {
        System.out.println("---------------------Before JAVA8 ------------------------------");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("key:value = " + entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("---------------------JAVA8 ------------------------------");
        map.entrySet().forEach(entry -> System.out.println("key:value = " + entry.getKey() + ":" + entry.getValue()));
    }

    /**
     * 遍历Map第五种
     * 通过k,v遍历，Java8独有的
     */
    public static void test5(Map<String, Object> map) {
        System.out.println("---------------------Only JAVA8 ------------------------------");
        map.forEach((key, value) -> System.out.println("key:value = " + key + ":" + value));
    }

}
