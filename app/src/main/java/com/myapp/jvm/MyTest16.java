package com.myapp.jvm;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyTest16  extends ClassLoader{
    private String classLoaderName;

    private  String fileExtensin=".class";

    public MyTest16(ClassLoader parent, String classLoaderName) {
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data=this.loadClassData(name);
        return this.defineClass(name,data,0,data.length);
    }

    private byte[] loadClassData(String name) {
        InputStream is=null;
        byte[] data=null;
        ByteArrayInputStream baos=null;

        try {
            is=new FileInputStream(new File(name,this.fileExtensin));
        }catch ( Exception e){

        }finally {

        }

        return new byte[0];
    }
}
