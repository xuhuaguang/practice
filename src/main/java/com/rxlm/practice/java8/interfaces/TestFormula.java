package com.rxlm.practice.java8.interfaces;

/**
 * @ClassName: TestFormula
 * @Description:
 * @Author: xz
 * @CreateDate: 2019/4/11 17:44
 * @Version: 1.0
 */
public class TestFormula {

    public static void main(String[] args) {
        Formula formula = new Formula() {

            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };
        System.out.println(formula.calculate(100));
        System.out.println(formula.sqrt(16));
    }
}
