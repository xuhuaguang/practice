package com.rxlm.practice.java8.interfaces;

import com.rxlm.practice.java8.bean.Person;

/**
 * @ClassName: PersonFactory
 * @Description:
 * @Author: xz
 * @CreateDate: 2019/4/17 15:15
 * @Version: 1.0
 */
public interface PersonFactory<P extends Person> {
    P create(String firstname, String lastname);
}
