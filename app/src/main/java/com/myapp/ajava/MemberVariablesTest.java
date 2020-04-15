package com.myapp.ajava;

public class MemberVariablesTest {
    /**
     * 对于final类型的成员变量的初始化方式
     * 1，声明变量时直接赋值
     * 2，在构造方法中赋值，如果一个类有多个构造方法，就要保证在每个构造方法中都要完成对final类型变量的初始化工作
     *
     * 对于final类型的引用变量来说，所谓的不能改变指的是引用的对象不能改变
     */
    private final  int a;
    public static final StringBuffer STRING_BUFFER=new StringBuffer();

    public MemberVariablesTest(int a) {
        this.a = a;
    }

    public MemberVariablesTest() {
        this.a=5;
    }

    public static void main(String[] args){
        STRING_BUFFER.append("");

    }
}
