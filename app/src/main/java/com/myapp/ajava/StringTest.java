package com.myapp.ajava;

public class StringTest {
    public static void main(String[] args){
        String s=new String("abc");
        String s1="abc";
        String s2=new String("abc");

        System.out.println(s==s1);
        System.out.println(s==s2);
        System.out.println(s1==s2);

        //等执行后生成几个对象，分别在哪里？

        /**
         * 等执行完第一行，生成两个对象 string pool
         * 先把括号"abc"放到string pool中 接下来new string("abc") 会在堆中生成一个"abc"对象
         * s是引用，s指向堆中的对象
         *
         * 等执行的二行，不会生成新的对象，如果是字面赋值而不是new一个对象，首先java会从string pool中查找是否存在
         * s1的引用指向string pool中的对象
         *
         * 等执行第三行，只要new就会在堆中生成一个新的对象 放在堆中
         *  s3的引用指向堆中新生成中的对象
         *
         *  八个原生数据类型等号比较的是他们的值
         *  java中等号永远比较的是两个对象的内存地址，比较等号两边的引用指向的是不是同一个对象
         *
         *  三个对象地址不同，所以都是false
         */

        System.out.println(s==s.intern());
        System.out.println(s1==s1.intern());
        System.out.println(s1.intern()==s2.intern());
        /**
         * intern
         *
         * s1.intern()==s2.intern() 相等的话，s1.equal与s2.equal相等
         *
         *
         */

        String hello="hello";
        String hel="hel";
        String lo="lo";


        System.out.println(hello="hel"+"lo");
        System.out.println(hello=="hel"+lo);

        /**
         * 加号两边都是字面值的话，相加后的结果会先在string pool中寻找相同的结果，如果找到则指向string pool中的对象
         *
         * 加号两边如果有一个不是字面值的话，Java不检查string pool,会在堆中生成一个新对象
         */
    }
}
