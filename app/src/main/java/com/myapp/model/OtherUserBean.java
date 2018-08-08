package com.myapp.model;

/**
 * Created by lihaipeng on 2018/6/5.
 */

public class OtherUserBean {
    String name;
    String age;

    public OtherUserBean(String name, String age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "OtherUserBean{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
