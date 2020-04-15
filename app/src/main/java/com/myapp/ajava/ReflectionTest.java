package com.myapp.ajava;

import java.lang.reflect.Field;

public class ReflectionTest {

    /**
     * 获得某个类的对应的class对象的方式
     * 1，使用类的.class语法
     * 2，通过类的对象的getClass方法
     * 3，通过class对象的forName（）方法
     * 4，对于包装类，可以通过.Type语法方式
     *
     */
    /**
     *
     * @param args
     */
    public static void main(String[] args){
        Class<?> clazz=PrivateTest.class;
        try {
            PrivateTest pt=new PrivateTest();

            Field field=clazz.getDeclaredField("name");

            field.setAccessible(true);
            field.set(pt,"world");

            System.out.println(pt.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
