package com.cks.user.model;

/**
 * @Author: cks
 * @Date: Created by 下午14:35 2018/2/27
 * @Package: com.cks.netty.client
 * @Description: user实体
 */
public class User {

    private Integer id;

    private String name;

    private String age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


}
