package com.myapp.java.jichu;

/**
 * 字符串
 */
public class StringTest {
    public static void main(String[] args){
        //字符常量池生成对象，然后堆中生成引用对象
        String s=new String("abc");
        String s1="abc";
        String s2=new String("abc");
        String s3=new String("abc")+new String("e");
        String s4="abce";
        String s5="abc"+"e";
        String s6="abc"+new String("e");

        System.out.println(s==s1);
        System.out.println(s==s2);
        System.out.println(s1==s2);

        System.out.println(s==s.intern());
        System.out.println(s1==s1.intern());
        System.out.println(s1==s.intern());

        System.out.println(s2==s2.intern());
        System.out.println(s.intern()==s2.intern());
        System.out.println(s3==s4);
        System.out.println(s3.intern()==s4);
        System.out.println(s4==s5);
        System.out.println(s4==s6);
    }
}
