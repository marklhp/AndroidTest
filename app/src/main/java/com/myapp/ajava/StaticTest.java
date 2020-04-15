package com.myapp.ajava;

public class StaticTest
{

    private static StaticTest st=new StaticTest();

    public static  int count1;
    public static  int count2=0;

    private StaticTest(){
        count1++;
        count2++;
}

    public static  StaticTest getInstance(){
        return st;
    }


    public static void main(String[] args){
        StaticTest st=StaticTest.getInstance();
        System.out.println("count1"+st.count1);
        System.out.println("count2"+st.count2);
    }
    /**
     * 静态变量的初始化顺序
     */
}
