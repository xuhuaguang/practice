package com.rxlm.practice.java8.lambda;

import com.rxlm.practice.java8.interfaces.Converter;

/**
 * @ClassName: LocalVariable
 * @Description:访问局部变量
 * @Author: xz
 * @CreateDate: 2019/4/17 16:17
 * @Version: 1.0
 */
public class LocalVariable {

    /**
     * Lambda表达式可以分为两部分：
     * 左侧：指定了Lambda表达式需要的所有参数
     * 右侧：指定了Lambda体，即lambda表达式要执行的功能
     * @param args
     */
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        final int num = 1;
        Converter<Integer,String> converter = (from) ->String.valueOf(from+num);
        /*Converter<Integer,String> converter = new Converter<Integer, String>() {
            @Override
            public String convert(Integer from) {
                return String.valueOf(from+num);
            }
        };*/
        System.out.println(converter.convert(2));
    }
}
