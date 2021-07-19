package com.myapp.java.jichu.t10;

import java.util.Random;

class Test10 {
    /**
     * 1,关于多态；父类或者接口类型的引用指向子类或者实现该接口的类的对象
     * 2,多态是运行时行为,不是编译时行为
     * @param args
     */
    public static void main(String[] args){
        Parent parent=new Child2();
        parent.doSomething();

        Parent3 parent3=new Child3();
        parent3.doSomething();

        Test10 test10=new Test10();
        System.out.println(test10.generate());
    }

    public Parent3 generate(){
        Random random=new Random();
        int number=random.nextInt(3);
        switch (number){
            case 0:
                return new Child3();
            case 1:
                return new Child4();
            case 2:
                return new Child5();
        }
        return null;
    }
}
class Parent{


    public void doSomething(){
        System.out.println("Parent");
    }


}
class Child2 extends Parent{
    public void doSomething(){
        System.out.println("Child2");
    }
    public void doSomething2(){
        System.out.println("Child22");
    }
}

interface Parent3{
    void doSomething();
}
class Child3 implements Parent3 {
    @Override
    public void doSomething() {
        System.out.println("Child3");
    }
}
class Child4 implements Parent3 {
    @Override
    public void doSomething() {
        System.out.println("Child4");
    }
}
class Child5 implements Parent3 {
    @Override
    public void doSomething() {
        System.out.println("Child5");
    }
}