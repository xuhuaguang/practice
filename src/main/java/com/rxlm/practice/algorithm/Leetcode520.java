package com.rxlm.practice.algorithm;

/**
 * @ClassName: Solution 检测大写字母
 * @Author: xz
 * @CreateDate: 2019/7/10 13:50
 * @Version: 1.0
 */
public class Leetcode520 {

    public static void main(String[] args) {
        boolean usa = detectCapitalUse("FlaG");
        System.out.println(usa);
    }


    /**
     * 首先遍历字符串所有字符，统计大写字母个数。 然后分三种情况：
     * 1.大写字母个数为0，或者大写字母个数为字符串长度，说明此时为全大写或者全小写，返回true。
     * 2.首字母大写，大写字母个数为1，说明此时只有首字母大写，返回true。
     * 3.其余返回false。
     * @return
     */
    public static boolean detectCapitalUse2 (String word) {
        return false;
    }

    /**
     * 思路
     * 标签：字符串遍历
     * 遍历一遍字符串，分别记录大于‘a’和小于‘a’的数量
     * 若全大于a说明是全小写，反之全大写
     * 若只有一个小于a，载判断是否为第一个字符
     */



    /**
     * 暴力法
     * @param word
     * @return
     */
    public static boolean detectCapitalUse(String word) {
        if (word.toUpperCase().equals(word)) return true;
        if (word.toLowerCase().equals(word)) return true;
        String f = word.substring(0, 1);
        String last = word.substring(1, word.length());
        if (f.equals(f.toUpperCase())) {
            String[] split = last.split(" ");
            for (int i = 0; i < split.length; i++) {
                if (split[i].equals(split[i].toLowerCase())) {
                    return true;
                }
            }
        } else {
            return false;
        }
        return false;
    }

}
