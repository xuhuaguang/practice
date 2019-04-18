package com.rxlm.practice.java8.lambda;

import com.rxlm.practice.java8.bean.Person;
import com.rxlm.practice.java8.interfaces.Converter;
import com.rxlm.practice.java8.interfaces.PersonFactory;

/**
 * @ClassName: Converter
 * @Description:
 *          Lambda表达式可以分为两部分：
 *          左侧：指定了Lambda表达式需要的所有参数
 *          右侧：指定了Lambda体，即lambda表达式要执行的功能
 * @Author: xz
 * @CreateDate: 2019/4/17 10:41
 * @Version: 1.0
 */
public class ConverterClass {

    public static void main(String[] args) {
        test();
        test2();
        test3();
        test4();
    }

    public static void test() {
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer convert = converter.convert("123");
        System.out.println(convert);
    }

    public static void test2() {
        Converter<String, Integer> converter = new Converter<String, Integer>() {
            @Override
            public Integer convert(String from) {
                return Integer.valueOf(from);
            }
        };
        System.out.println(converter.convert("123"));
    }

    /**
     * 方法与构造函数引用
     * Java 8 允许你使用 :: 关键字来传递方法或者构造函数引用，上面的代码展示了如何引用一 个静态方法，
     * 我们也可以引用一个对象的方法：
     */
    public static void test3() {
        Converter<String,Integer> converter = Integer:: valueOf;
        Integer convert = converter.convert("456");
        System.out.println(convert);
    }

    /**
     * 我们只需要使用 Person::new 来获取 Person 类构造函数的引用，Java编译器会自动根据
     * PersonFactory.create 方法的签名来选择合适的构造函数。
     */
    public static void test4() {
        PersonFactory<Person> personPersonFactory = Person::new;
        Person person = personPersonFactory.create("tom", "jack");
        System.out.println(person.toString());
    }
}
