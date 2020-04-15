package com.myapp.ajava;

public class ExceptionTest {
    public static void main(String[] args){
       System.out.println(reStr());
    }

    public static String reStr(){
        try {
            int s=4/0;
            return "-----";
        }catch (Exception e){
            System.out.println("exception");
            return "|||";
        }finally {
            System.out.println("finally");
            return "|||---";
        }
    }
}
