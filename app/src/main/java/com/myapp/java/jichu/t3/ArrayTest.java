package com.myapp.java.jichu.t3;

/**
 * 是否可以编译通过
 * 数组存放的是引用地址
 */
class ArrayTest {
    public static void main(String[] args){
        I[] i=new I[2];
//        I i1=new I();
        i[0]=new C();
        i[1]=new C();
    }
}
interface I{}

class C implements I{}