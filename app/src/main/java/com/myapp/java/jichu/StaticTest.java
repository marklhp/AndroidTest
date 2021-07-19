package com.myapp.java.jichu;

/**
 * 初始化流程
 */
class StaticTest {
    public static  int count3;
    public static  int count4=0;
    private static StaticTest st=new StaticTest();
    public static  int count1;
    public static  int count2=0;


    private StaticTest(){
        count1++;
        count2++;
        count3++;
        count4++;
    }

    public static StaticTest getInstance(){
        return st;
    }
    public static void main(String[] args){
        StaticTest st=StaticTest.getInstance();
        System.out.println("count1:"+st.count1);
        System.out.println("count2:"+st.count2);
        System.out.println("count2:"+st.count3);
        System.out.println("count2:"+st.count4);
    }


}
