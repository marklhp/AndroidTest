package com.myapp.java.jichu.t3;

/**
 * 是否可以编译通过
 */
class ExceptionTest {
    public static void main(String[] args){
        try {
            String s=null;
//            return;
//            System.exit(0);
        }catch (Exception ex){
            System.out.println("execption");
        }finally {
            System.out.println("finally");
        }
    }
}
