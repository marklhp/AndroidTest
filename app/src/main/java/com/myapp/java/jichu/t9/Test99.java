package com.myapp.java.jichu.t9;

import java.util.Date;

/**
 * 匿名内部类
 * 关于匿名内部类，该类一定是继承了某个类父类或某个接口
 *
 * 1,静态内部类
 * 2,成员内部类
 * 3,局部内部类
 * 2,匿名内部类
 */
class Test99 {
    public String get(Date date){
        return date.toLocaleString();
    }
    public static void main(String[] args){
        Test99 test99=new Test99();
        System.out.println(test99.get(new Date(){}));
        System.out.println(test99.get(new Date()));
        System.out.println(test99.get(new Date(){
            @Override
            public String toLocaleString() {
                return "hello world";
            }
        }));
    }
}
