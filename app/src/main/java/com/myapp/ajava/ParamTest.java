package com.myapp.ajava;

public class ParamTest {
    public void changer(int a){
        a=3;
    }

    public void changePoint(Point point){
        point.x=5;
        point.y=6;
    }
    public void changeString(String str){
        str="abc";
    }
    public static void main(String[] args){
        ParamTest pt=new ParamTest();
        int a=1;

        pt.changer(a);

        System.out.println(a);


        Point point=new Point(1,2);
        pt.changePoint(point);
        System.out.println(point.x);
        System.out.println(point.y);

        String str="xmj";
        pt.changeString(str);
        System.out.println(str);

    }
    /**
     * 引用类型的传递是把地址传递过去
     * 在java里，对于方法的参数传递，不管是原生数据类型还是引用类型，一律是传值：pass by value
     * 对于原生类型的值是它被赋予的值
     * 对于引用类型的值是引用的地址的值
     *
     */
}

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
