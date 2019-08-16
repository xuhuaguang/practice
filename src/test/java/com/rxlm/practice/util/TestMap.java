package com.rxlm.practice.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName: TestMap
 * @Description:
 * @Author: xz
 * @CreateDate: 2019/5/23 17:21
 * @Version: 1.0
 */
public class TestMap {

    public static void main(String[] args) {
        testMap(10000);
    }
    /**
     * 测试Map
     * @param  keyValueNum：键值对的数量
     */
    public static void testMap(int keyValueNum) {
        /**
         * 创建map
         */
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < keyValueNum; i++){
            map.put(i, i);
        }
        /**
         * keySet遍历
         */
        long start = System.currentTimeMillis();
        for (Integer key : map.keySet()) {
            //Integer value = map.get(key);
        }
        /*Iterator<Integer> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            int key = iterator.next();
            //int value = map.get(key); //效率低下原因在此，因为此处会再次遍历Map ，取得key对应的value值。
        }*/
        System.out.println("keySet consume time = " + (System.currentTimeMillis() - start));
        /**
         * entrySet遍历
         */
        start = System.currentTimeMillis();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            //Integer value = entry.getValue();
        }
        /*Iterator<Map.Entry<Integer, Integer>> iterator2 = map.entrySet().iterator();
        Map.Entry<Integer, Integer> entry = null;
        while(iterator2.hasNext()){
            entry = iterator2.next();
            int key = entry.getKey();
            //int value = entry.getValue();
        }*/
        System.out.println("entrySet consume time = " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        map.forEach((k,v)->{
            int key = k;
            //int value= v;
        });
        System.out.println("forEach consume time = " + (System.currentTimeMillis() - start));
    }
}
