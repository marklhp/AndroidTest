package com.myapp.java;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Handler;
import android.view.View;

import com.myapp.utils.ThreadPoolUtil;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class MyTest {
    public static class Super {
        public void a() {
            System.out.println("1");
            b();
        }

        public void b() {
            System.out.println("2");
        }
    }

    public static class Test2 extends Super {
        @Override
        public void a() {
            System.out.println("3");
            super.a();
        }

        @Override
        public void b() {
            System.out.println("4");
        }


    }
    public static void main(String args[]) {
        System.out.println("Test2----------");

        new Test2().a();
    }

}
