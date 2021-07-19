package com.myapp.java.jichu.t9;

class Test9 {
    /**
     * & 与&&的区别
     * &可以做位与运算，也可以做与逻辑运算
     * &&做与逻辑运算，有短路功能
     * @param args
     */
    public static void main(String[] args){
        int a=3;
        int b=5;
        int c=a&b;
        System.out.println(c);

        int e=1;
        int f=2;
        if ((e==2)&&(f=3)==5){

        }
        System.out.println(e+"=="+f);

        if ((e==2)&(f=3)==5){
        }
        System.out.println(e+"=="+f);
    }
}
