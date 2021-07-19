package com.myapp.java.jichu.t9;

import java.util.ArrayList;
import java.util.List;

/**
 * 范型
 * 能否编译通过
 *
 * 关于范型的继承，
 * ArrayList<Object> 继承了List<Object>
 *     ArrayList<String> 没有继承List<Object>
 */
class Test999 {
    public void method1(List<Object> list){

    }
    public void method2(){
        method1(new ArrayList<Object>());
//        method1(new ArrayList<String>());
//        method1(new ArrayList<Integer>());
    }
    public void method3(List<? extends Object> list){

    }
    public void method4(){
        method3(new ArrayList<Object>());
        method3(new ArrayList<String>());
        method3(new ArrayList<Integer>());
    }

    public void method5(List<?> list){

    }

    /**
     * 只写？等价于 ? extends Object
     */
    public void method6(){
        method5(new ArrayList<Object>());
        method5(new ArrayList<String>());
        method5(new ArrayList<Integer>());
    }
}
