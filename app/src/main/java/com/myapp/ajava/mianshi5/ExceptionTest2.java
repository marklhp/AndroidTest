package com.myapp.ajava.mianshi5;

import java.io.IOException;

public class ExceptionTest2 {
    public void doSomething() throws IOException{
        System.out.println("do somethine");
    }
    public static void  main(String[] args){
        ExceptionTest2 test2=new ExceptionTest2();
        try {
            test2.doSomething();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 一个类的声明可否既是abstract的，又是final的  no
     * 抽象类不能被实例，需要事例继承的子事例  final不能被继承   矛盾
     *
     * 为什么对于一个public类型的终态的成员变量，一般都使用static
     * public static final String st="abc";
     * 节省内存
     * final 不能改变，如果创建十个实例就有十份变量相同的值内存 static 保证了在内存中只有一份
     *
     * ==和equal的区别
     *== 永远比较的是引用地址  equals 在object中也是比较的是引用地址，而在string，等其他类中比较的是重写后的内容
     * 不重写的话还是比较的是引用地址
     *
     */
}
