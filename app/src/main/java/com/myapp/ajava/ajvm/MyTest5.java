package com.myapp.ajava.ajvm;

public class MyTest5 {
    public void test(Grandpa grandpa){
        System.out.println("grandpa");
    }
    public void test(Father father){
        System.out.println("father");
    }
    public void test(Son son){
        System.out.println("son");
    }

    public static void main(String[] args){
        Grandpa g1=new Father();
        Grandpa g2=new Son();

        MyTest5 myTest5=new MyTest5();

        myTest5.test(g1);
        myTest5.test(g2);
    }
}
