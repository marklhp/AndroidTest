package com.myapp.java.jichu;

/**
 * 在java里面，对于方法的参数传递，不管是原生类型还是引用类型，一律是传值 对于原生类型值是赋的值，对于引用类型值是赋的引用的值
 */
class ParamTest {
    /**
     * 原生类型传参时传的是值，不是引用
     * @param a
     */
    public void changeInt(int a){
        a=3;
    }

    public void changeString(String a){
        a="45";
    }

    public void changePoint(Point point){
        point.x=5;
        point.y=6;
    }
    public static void main(String[] args){
        int a=1;
        String b="23";
        ParamTest pt=new ParamTest();
        pt.changeInt(a);
        System.out.println(a);

        Point point=new Point(1,2);
        pt.changePoint(point);
        System.out.println(point.toString());

        pt.changeString(b);
        System.out.println(b);
    }

    public static class Point{

        int x;
        int y;
        public Point(int mx,int my){
            x=mx;
            y=my;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

}
