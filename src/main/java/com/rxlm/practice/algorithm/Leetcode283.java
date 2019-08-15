package com.rxlm.practice.algorithm;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @ClassName: Leetcode283
 * @Description:
 * @Author: xz
 * @CreateDate: 2019/7/10 16:29
 * @Version: 1.0
 */
public class Leetcode283 {

    public static void main(String[] args) {
        int[] nums = {0,21,0,3,12};
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
