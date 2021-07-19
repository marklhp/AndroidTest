package com.myapp.java.jichu.t6;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class SetTest {
    public static void main(String[] args) {
//        Set<String> set=new HashSet();
//        set.add("abc");
//        set.add("xyz");
//        set.add("abc");
//        Iterator<String> iterable =set.iterator();
//        while (iterable.hasNext()){
//            System.out.println(iterable.next());
//        }
//
//    }
        Set<People> set = new HashSet<>();
        set.add(new People("zhangsan"));
        set.add(new People("lisi"));
        set.add(new People("zhangsan"));

        Iterator<People> iterable = set.iterator();
        while (iterable.hasNext()) {
            System.out.println(iterable.next());
        }
    }

    static class People {
        String name;

        public People(String name) {
            this.name = name;
        }
    }
}