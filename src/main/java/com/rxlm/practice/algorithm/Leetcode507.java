package com.rxlm.practice.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Leetcode507
 * @Description:
 * @Author: xz
 * @CreateDate: 2019/7/10 14:37
 * @Version: 1.0
 */
public class Leetcode507 {

    public static void main(String[] args) {
        int num = 27;
        boolean b = checkPerfectNumber(num);
        System.out.println(b);
    }

    public static boolean checkPerfectNumber(int num) {
        int sum = 1;
        for(int i = 2; i < num/i; i++) {
            if(num % i == 0) {
                sum += i + num/i;
            }
        }
        return num != 1 && sum == num;
    }
}
