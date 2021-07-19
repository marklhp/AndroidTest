package com.myapp.java.jichu.t8;

import java.util.ArrayList;
import java.util.List;

class Test8 {
    /**
     * 1，请问arraylist linkedlist vector 区别
     * arraylist底层实际是采用数组实现的，并且数组类型是object类型的
     * arraylist 和vector底层都是采用数组实现的，不过arraylist所有方法都不是同步的，
     * 对于vector大部分方法是同步的
     * 对于Arraylist查找速度非常快，增加删除速度非常慢，vector也是（本质上是由数组特点决定的）
     * linkedlist，查找速度非常慢，增加删除速度非常快，本质上由双向循环链表特点决定的
     */
    public static void main(String[] args){
        List list=new ArrayList();
    }
}
