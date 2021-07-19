package com.myapp.java.jichu;

/**
 * 初始化流程
 */
class OrderTest {
    public static void main(String[] args){
        new Child();
    }
}

class Parent{
    static  String name="hello";
    static {
        System.out.println("parent static block");
    }
    public Parent(){
        System.out.println("parent constructor");
    }
}
class Child extends Parent{
    static  String name="world";
    static {
        System.out.println("child static block");
    }
    public Child(){
        System.out.println("child constructor"+"=="+name);
    }
}
