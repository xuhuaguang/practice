package com.rxlm.practice.algorithm;

/**
 * @Description: 算法类
 * @Author: xz
 * @CreateDate: 2019/7/2 17:10
 * @Version: 1.0
 */
public class LeetcodeAlm {
    public int countPrimeSetBits(int L, int R) {
        for (int i = L; i < R; i++) {

        }
        return 0;
    }

    /**
     * 二进制的最末位为0表示该数为偶数，最末位为1表示该数为奇数。
     *
     */
    public static int getCount(int nums) {
        int count = 0;
        while (nums != 0) {
            count += nums & 1;
            nums =  nums >> 1 ;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getCount(6));
    }

}
