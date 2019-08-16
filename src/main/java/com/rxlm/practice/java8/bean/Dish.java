package com.rxlm.practice.java8.bean;

/**
 * @ClassName: Dish
 * @Description:
 * @Author: xz
 * @CreateDate: 2019/5/26 13:27
 * @Version: 1.0
 */
public class Dish {
    /*菜肴名称*/
    private final String name;
    private final boolean vegetarian;
    /*卡路里*/
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public boolean isVegetarian() {
        return vegetarian;
    }
    public int getCalories() {
        return calories;
    }
    public Type getType() {
        return type;
    }
    @Override
    public String toString() {
        return name;
    }
    public enum Type {
        MEAT, FISH, OTHER
    }
}
