package com.myapp.java.jichu.t3;

/**
 * 是否可以改变
 * 对于final类型的引用变量来说，所谓的不能改变指的是该引用不能改变
 */
class Test2 {
    public static final StringBuilder s=new StringBuilder();
    public static void main(String[] args){
        s.append("hello");
//        s=new StringBuilder();
    }
}
