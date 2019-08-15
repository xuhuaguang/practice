package com.rxlm.practice.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName: Solution
 * @Description:
 * @Author: xz
 * @CreateDate: 2019/7/2 10:48
 * @Version: 1.0
 */
public class Solu {

    public List<List<Integer>> permute(int[] nums){
        int[] used = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> list_total = new ArrayList<>();
        funcR(nums,used,list,list_total);
        return list_total;
    }

    private void funcR(int[] nums,int[] used,List<Integer> list_in,List<List<Integer>> list_total){
        if (list_in.size() == nums.length) {
            list_total.add(new ArrayList<>(list_in));
            return;
        }
        for(int i=0;i<nums.length;i++) {
            if(used[i]==0) {
                list_in.add(nums[i]);
                used[i]=1;
                funcR(nums,used,list_in,list_total);
                used[i]=0;
                list_in.remove(list_in.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        String[] nums = {"a", "b", "c"};
        Solu s = new Solu();
        List<List<String>> permutes = s.permute(nums);
        System.out.println(permutes.toString());
        System.out.println(UUID.randomUUID().toString().replace("-",""));
    }
    //第二种
    List<List<String>> lists = new LinkedList<>();
    public List<List<String>> permute(String[] nums) {
        solution(nums, nums.length-1);
        return lists;
    }
    public void solution(String[] nums, int k) {
        if (k == 0) {
            List<String> list = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            lists.add(list);
        } else {
            for (int i = k; i >= 0; i--) {
                String temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
                solution(nums, k -1);
                temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
            }
        }
    }

}
