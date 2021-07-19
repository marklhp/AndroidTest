package com.myapp.java.jichu.t10;

/**
 * 单例
 */
class Test1000 {
    private Test1000(){}
    private static volatile Test1000 test1000;
    private static Test1000 getInstance(){
        if (test1000==null){
            synchronized (Test1000.class){
                if (test1000==null){
                    test1000=new Test1000();
                }
            }
        }
        return test1000;
    }
}
