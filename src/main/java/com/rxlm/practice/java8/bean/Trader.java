package com.rxlm.practice.java8.bean;

/**
 * @ClassName: Trader
 * @Description:
 * @Author: xz
 * @CreateDate: 2019/6/5 12:49
 * @Version: 1.0
 */
public class Trader {
    private final String name;
    private final String city;
    public Trader(String n, String c){
        this.name = n;
        this.city = c;
    }
    public String getName(){
        return this.name;
    }
    public String getCity(){
        return this.city;
    }
    public String toString(){
        return "Trader:"+this.name + " in " + this.city;
    }
}
