package com.myapp.ajava.mianshi5;

public class ExceptionTest {
    public void doSomething() throws  ArithmeticException{
        System.out.println("do something");

    }
    public  static void main(String[] args){
        ExceptionTest test=new ExceptionTest();
        test.doSomething();
    }
    /**
     * java中异常分为两类：
     * 1，checked exception
     * a,继续抛出
     * b,try
     * 2,unchecked exception (runtime excetion) 可以不做任何处理
     */
}
