package com.myapp.ndk;

public class NdkTools {

    static {
        System.loadLibrary("native-lib");
    }
    public static native String stringFromJNI();
}
