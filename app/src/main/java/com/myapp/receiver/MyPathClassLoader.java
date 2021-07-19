package com.myapp.receiver;

import android.os.AsyncTask;

import com.myapp.utils.ThreadPoolUtil;

import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import dalvik.system.PathClassLoader;

class MyPathClassLoader extends PathClassLoader {
    public MyPathClassLoader(String dexPath, ClassLoader parent) {
        super(dexPath, parent);
    }

    public MyPathClassLoader(String dexPath, String librarySearchPath, ClassLoader parent) {
        super(dexPath, librarySearchPath, parent);
        ExecutorService executor= ThreadPoolUtil.getSingleThread();
        Future<?> submit = executor.submit(new Runnable() {
            @Override
            public void run() {

            }
        });

    }
}
