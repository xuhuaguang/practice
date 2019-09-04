package com.rxlm.practice.algorithm;

/**
 * 测试各种数据结构
 */
public class TestSJJG {

    public static void main(String[] args) {

        int[] a = {20,40,30,10,60,50,70};
        bubbleSort(a,a.length);
    }

    /**
     * 冒泡排序
     * @param a
     * @param n
     */
    public static void bubbleSort(int[] a,int n) {
        //需要的次数
        for (int i = n-1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        System.out.println("进入冒泡排序");
        for (int i : a) {
            System.out.println(i);
        }
    }


}
