package com.rxlm.practice.java8.lambda;

import com.rxlm.practice.java8.interfaces.Converter;

/**
 * @ClassName: Lambda4
 * @Description:访问对象字段与静态变量
 * @Author: xz
 * @CreateDate: 2019/4/17 16:46
 * @Version: 1.0
 */
public class Lambda4 {
    /**
     * 和本地变量不同的是，lambda 内部对于实例的字段以及静态变量是即可读又可写
     */
    static int outerStaticNum;
    int outerNum;
    void testScopes() {
        Converter<Integer,String> converter1 = (from)->{
            outerNum = 23;
            return String.valueOf(from);
        };
        System.out.println(converter1.convert(outerNum+1));
        Converter<Integer,String> converter2 = (from) -> {
            outerStaticNum = 72;
            return String.valueOf(from);
        };
        System.out.println(converter2.convert(outerStaticNum+1));
    }

    public static void main(String[] args) {
        new Lambda4().testScopes();
        //System.out.println(outerNum);
        System.out.println(outerStaticNum);

    }
}
