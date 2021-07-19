package com.myapp.java.jichu;

import java.lang.reflect.Field;

/**
 * 是否可以把name的值hello改成world
 */
class PrivateTest {
    private String name="hello";
    public String getName(){
        return name;
    }
}
/**
 * 获得某个类的对应的class对象的方式
 * 1，使用类的.class
 * 2，通过类的对象getClass
 * 3, 通过class对象的forName()
 * 4, 对于包装类可以通过.TYPE语法方式
 */
class RefleCtionTest{
    public static void main(String[] args){
        PrivateTest pt= null;
        try {
            pt = PrivateTest.class.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        Class clazz=PrivateTest.class;
        try {
            Field field=clazz.getDeclaredField("name");
            field.setAccessible(true);
            field.set(pt,"world");
            System.out.println(pt.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}