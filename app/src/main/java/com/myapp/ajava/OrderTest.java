package com.myapp.ajava;

public class OrderTest {
    public static void main(String[] strings){
        new Child();
    }

}

class  Parent{
    static String name="hello";

    static {
        System.out.println("parent static block");
    }

    public Parent() {
        System.out.println("parent constructor");
    }
}

class Child extends Parent{
    static String childname="world";

    static {
        System.out.println("child static block");
    }

    public Child() {
        System.out.println("child constructor");
    }
}
