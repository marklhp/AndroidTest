package com.myapp.ajava;

public class PrivateTest {
    //能否改变name的值为world    可以通过反射
    private String name="hello";

    public String getName(){
        return name;
    }
}
