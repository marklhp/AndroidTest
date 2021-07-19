package com.myapp.java.jichu.t10;

import java.util.Arrays;

/**
 * 返回真还是假
 *
 * 数组比较
 */
class Test100 {
    public static void main(String[] args){
        char[] ch1=new char[2];
        ch1[0]='a';
        ch1[1]='b';

        char[] ch2=new char[2];
        ch2[0]='a';
        ch2[1]='b';
        System.out.println(ch1.equals(ch2));

        String s1=new String(ch1);
        String s2=new String(ch2);
        System.out.println(s1.equals(s2));

        System.out.println(Arrays.equals(ch1,ch2));
        StringBuffer stringBuffer=new StringBuffer();
    }
}
