package com.myapp.ajava;

public class ArrayTest {

    public static void main(String[] args){
        I[] is=new I[3];
        is[0]=new C();
        System.out.println(is[0]);
        abs[] abss=new abs[2];
    }

}
interface I{}
class C implements I{

}
abstract class abs{

        }
