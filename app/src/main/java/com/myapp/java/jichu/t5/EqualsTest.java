package com.myapp.java.jichu.t5;
/**
 * == 和 equals的区别
 *
 */
class EqualsTest {
    public static void main(String[] args){
        String str1=new String("abc");
        String str2=new String("abc");

        System.out.println(str1==str2);
        System.out.println(str1.equals(str2));

        Object o=new Object();
        Object o1=new Object();
        System.out.println(o==o1);
        System.out.println(o.equals(o1));
//        StringBuffer
    }



}
