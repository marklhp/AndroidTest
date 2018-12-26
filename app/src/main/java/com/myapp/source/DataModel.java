package com.myapp.source;

public class DataModel {
    public static BaseModel request(Class clazz) {
        // 声明一个空的BaseModel
        BaseModel model = null;
        // 判断class对象是不是BaseModel的实例
        try {
            //利用反射机制获得对应Model对象的引用
            model = (BaseModel) clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

}
