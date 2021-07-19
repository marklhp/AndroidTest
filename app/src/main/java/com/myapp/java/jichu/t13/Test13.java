package com.myapp.java.jichu.t13;

import com.myapp.java.Test2;

class Test13 implements Cloneable {
    Test2 test2=new Test2();
    String string=new String("abc");
    /**
     * 在java中一个字符能否表示一个汉子？
     * 可以，在java中，一个字符表示16位，相当于2个字节（1byte=8bit）
     * @param args
     */
    public static void main(String[] args){
        char ch='北';
        Test13 test13=new Test13();
        try {
            System.out.println(ch+"--"+(test13.clone()==test13)+"---");
            System.out.println(ch+"--"+(((Test13)test13.clone())==test13)+"---");
            Test13 test131=(Test13)test13.clone();
            System.out.println(test131.string==test13.string);
            Test2 test21=((Test13)test13.clone()).test2;
            System.out.println(test21==test13.test2);
            test13.string="jjjj";


            test131.test2=new Test2("aaa");
            System.out.println(test21.testStr);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


    }
    /**
     * get、post的区别
     * 1，表单的method属性如果为get 那么所有的参数信息都会显示在浏览器的地址栏里面，当我们使用浏览器地址栏
     * 输入网址的方式来发送请求时，那么该请求一定是get方式
     * 2，对于get方式，底层是将所有参数附加在请求资源的后面一起传递的
     * 对于post方式，底层是将所有参数附加在请求参数的最后一行的下一行
     * 3，对于get方式，servlet采用doget方法来处理，对于post方式，servlet采用dopost方法来进行处理
     */
}
