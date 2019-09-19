//
// Created by haipeng li on 2019-09-18.
//
#include <jni.h>
#include <string>
extern "C"
JNIEXPORT jstring JNICALL
Java_com_myapp_ndk_NdkTools_stringFromJNI(JNIEnv *env, jobject thiz) {

    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}