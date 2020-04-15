package com.myapp.ajava;

public class Test {
    public static void main(String[] args) throws Exception{
        Parent1 parent1=new Child1();
        parent1.outPut();
    }

}

class Parent1{
    public void outPut() throws Exception{
        System.out.println("parent");
    }
}
class Child1 extends Parent1{
    public void outPut() throws NullPointerException {
        System.out.println("child");
    }
}

/**
 * 方法重写 override
 * 1,子类中的方法与父类的方法有相同的返回类型，相同的方法名称，相同的参数列表
 * 2，子类中的方法的访问级别不能低于父类中该方法的访问级别
 * 3，子类中方法的跑出异常范围不能大于父类抛出的异常范围
 *
 *
 */

