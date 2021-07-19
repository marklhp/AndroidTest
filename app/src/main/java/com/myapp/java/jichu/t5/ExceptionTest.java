package com.myapp.java.jichu.t5;

/**
 * java异常分为两类
 * 1，checked exception 某个方法抛出检查异常,则调用的方法需要抛出异常或catch处理  IOException
 *  处理方式
 *  a，继续抛出，消极抛出，直到jvm处理
 *  b，try catch
 *
 * 2，unchecked exception（runtime exception） 非检查异常可以处理，也可以不处理 ArithmeticException NullPointerException
 *
 */
class ExceptionTest {

    public void doSomething() throws NullPointerException{
        System.out.println("do something");
    }

    public static void main(String[] args){
        ExceptionTest test=new ExceptionTest();
        test.doSomething();
    }
}
