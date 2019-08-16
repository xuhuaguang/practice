package com.rxlm.practice.java8.bean;

/**
 * @ClassName: Apple
 * @Description:
 * @Author: xz
 * @CreateDate: 2019/5/25 9:40
 * @Version: 1.0
 */
public class Apple {

    private String color;

    private Integer weight;

    public Apple(String color, Integer weight) {
        this.color = color;
        this.weight = weight;
    }

    public Apple(){}

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
