package com.rxlm.practice.java8.bean;

/**
 * @ClassName: Person
 * @Description:
 * @Author: xz
 * @CreateDate: 2019/4/17 11:52
 * @Version: 1.0
 */
public class Person {
    String firstName;
    String lastName;

    public Person() {

    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
