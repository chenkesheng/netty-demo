package com.cks.netty.bye.serializable;

/**
 * @Author: cks
 * @Date: Created by 2019/7/26 9:33
 * @Package: com.cks.netty.bye.serializable
 * @Description:
 */
public class Person implements Cloneable{

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
