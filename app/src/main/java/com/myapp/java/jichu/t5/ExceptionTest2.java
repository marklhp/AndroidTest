package com.myapp.java.jichu.t5;

import java.io.IOException;

/**
 * 能否编译通过
 */
class ExceptionTest2 {
    public void doSomething() throws IOException{
        System.out.println("do something");
    }
    abstract class B{}
    public static void main(String[] args){
//        ExceptionTest2 test=new ExceptionTest2();
//        try {
//            test.doSomething();
//        }catch (Exception e){
//
//        }catch (IOException e){
//
//        }
//        B b = new B();


    }

    /**
     * 一个类的声明可否既是抽象的，又是final的 为什么 不可以
     *
     */
    /**
     * 为什么对于一个public类型的终态的成员变量，一般都要声明为static
     * public static final String str="abc";
     * 节省内存
     * 不修饰，每个实例都有内存备份，修饰只有一份
     *
     */

}
