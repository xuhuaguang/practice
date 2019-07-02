package com.rxlm.practice.util;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description:检查数组是否包含某个值的方法
 * @Author: xz
 * @CreateDate: 2019/6/28 11:02
 * @Version: 1.0
 */
public class StringUtils {


    /**
     * 使用List判断是否包含
     * @param arr
     * @param targetValue
     * @return
     */
    public static boolean useList(String[] arr,String targetValue){
        return Arrays.asList(arr).contains(targetValue);
    }

    /**
     * 使用Set判断是否包含
     * @param arr
     * @param targetValue
     * @return
     */
    public static boolean useSet(String[] arr,String targetValue){
        Set<String> set = new HashSet<String> (Arrays.asList(arr));
        return set.contains(targetValue);
    }

    /**
     * 使用循环判断
     * @param arr
     * @param targetValue
     * @return
     */
    public static boolean useLoop(String[] arr,String targetValue){
        for(String s:arr){
            if(s.equals(targetValue)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找有序数组中是否包含某个值的用法
     * @param arr
     * @param targetValue
     * @return
     */
    public static boolean useArraysBinarySearch(String[] arr,String targetValue){
        int str = Arrays.binarySearch(arr, targetValue);
        if(str > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 使用ArrayUtils
     * @param arr
     * @param targetValue
     * @return
     */
    public static boolean useArrayUtils(String[] arr,String targetValue){
        return ArrayUtils.contains(arr,targetValue);
    }


    public static void main(String[] args) {
        String[] arr=new String[]{"CD","BC","EF","DE","AB","JK"};
        int nums = 10000;
        int millsec = 1000000;
        //use list
        long startTime=System.nanoTime();
        for(int i = 0;i < nums; i++){
            useList(arr, "A");
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("useList:"+duration/millsec);

        //use set
        long startTime2=System.nanoTime();
        for(int i = 0;i < nums; i++){
            useSet(arr, "A");
        }
        long endTime2=System.nanoTime();
        long duration2 = endTime2 - startTime2;
        System.out.println("useSet:"+duration2/millsec);

        //use loop
        long startTime3=System.nanoTime();
        for(int i = 0;i < nums; i++){
            useLoop(arr, "A");
        }
        long endTime3 = System.nanoTime();
        long duration3 = endTime3 - startTime3;
        System.out.println("useLoop:"+duration3/millsec);

        //use Arrays.binarySearch()
        long startTime4=System.nanoTime();
        for(int i = 0; i < nums;i++){
            useArraysBinarySearch(arr, "A");
        }
        long endTime4 = System.nanoTime();
        long duration4 = endTime4-startTime4;
        System.out.println("useArraysBinarySearch:"+duration4/millsec);
    }
    /**
     *
     *  显然，使用一个简单的循环方法比使用任何集合都更加高效。许多开发人员为了方便，
     *  都使用第一种方法，但是他的效率也相对较低。因为将数组压入Collection类型中，
     *  首先要将数组元素遍历一遍，然后再使用集合类做其他操作。
     *
     */
}
