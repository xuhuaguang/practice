package com.rxlm.practice.corejava;

/**
 * 类初始化顺序(继承)
 *  父类静态初始化块
 *  子类静态初始化块
 *
 *  父类代码块 { }
 *  父类构造方法
 *  子类代码块 { }
 *  子类构造方法
 */
public class B extends TestInitializationOrder{
    static {
        System.out.println("a");
    }

    public B () {
        System.out.println("b");
    }

    public static void main(String[] args) {
        TestInitializationOrder a = new B();
                                a = new B();
    }
}
