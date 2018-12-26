package com.myapp.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;


import com.myapp.App;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * UncaughtException处理类,当程序发生Uncaught异常的时候,有该类来接管程序,并记录发送错误报告.
 *
 * @author user
 */
public class CrashHandler implements Thread.UncaughtExceptionHandler {


    public static final String TAG = "CrashHandler";

    private Context mContext;

    //系统默认的UncaughtException处理类
    private Thread.UncaughtExceptionHandler mDefaultHandler;
    //CrashHandler实例
    private static CrashHandler INSTANCE;

    //用于格式化日期,作为日志文件名的一部分
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.US);
    private boolean isSaveException;
    private Class clazz;

    /**
     * 保证只有一个CrashHandler实例
     */
    private CrashHandler() {
    }

    /**
     * 获取CrashHandler实例 ,单例模式
     */
    public static CrashHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CrashHandler();
        }
        return INSTANCE;
    }

    /**
     * 初始化
     *
     * @param context
     * @param isSaveException false 测试时关闭,true 上线时开启记录异常
     */
    public void init(Context context, boolean isSaveException,Class clazz) {
        mContext = context;
        //获取系统默认的UncaughtException处理器
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        //设置该CrashHandler为程序的默认处理器
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.isSaveException = isSaveException;
        this.clazz=clazz;
    }

    /**
     * 当UncaughtException发生时会转入该函数来处理
     */
    @Override
    public void uncaughtException(Thread thread, final Throwable ex) {
        Log.e("异常捕捉","",ex);
        //收集设备参数信息
        //collectDeviceInfo(mContext);
        if (isSaveException) {
            //保存日志文件

            saveCrashInfo2File(ex);
            Intent intent = new Intent(App.context, clazz);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            App.context.startActivity(intent);
            System.exit(1);
        } else {
            saveCrashInfo2File(ex);
            mDefaultHandler.uncaughtException(thread, ex);
        }
    }

    private void saveCrashInfo2File(Throwable ex) {
        SharedPreferences.Editor edit = App.context.getSharedPreferences("appinfo", Context.MODE_PRIVATE).edit();
        edit.putString("throwable",ex.getMessage()).apply();
    }

//    /**
//     * 保存错误信息到文件中
//     *
//     * @param ex
//     * @return 返回文件名称, 便于将文件传送到服务器
//     */
//
//    public void saveCrashInfo2File(Throwable ex) {
//        StringBuffer sb = new StringBuffer();
//        sb.append("version = " + DeviceUtil.getVersionNumber() + "\r\n");
//        sb.append("设备信息--" + DeviceUtil.getMobileInfo() + "\r\n");
//
//        Writer writer = new StringWriter();
//        PrintWriter printWriter = new PrintWriter(writer);
//        ex.printStackTrace(printWriter);
//        Throwable cause = ex.getCause();
//        while (cause != null) {
//            cause.printStackTrace(printWriter);
//            cause = cause.getCause();
//        }
//        printWriter.close();
//        String result = writer.toString();
//        sb.append(result);
//        try {
//            long timestamp = System.currentTimeMillis();
//            String time = formatter.format(new Date());
//            String fileName = "Android_exception_" + time + "_" + timestamp + ".txt";
////            String fileName = "Android_exception"/* + time + "#" + timestamp*/ + ".txt";
//            if (SDCardUtils.SDCardIsReady()) {
//                String path = SDCardUtils.getExternalCacheDownloadDir()+"/logback";
//                File dir = new File(path);
//                if (!dir.exists()) {
//                    dir.mkdirs();
//                }
//                FileOutputStream fos = new FileOutputStream(path + fileName);
//                fos.write(sb.toString().getBytes());
//                fos.close();
//            }
//        } catch (Exception e) {
//            Log.e(TAG, "an error occured while writing file...", e);
//        }
//
//
//    }

    /**
     * 保存错误信息到文件中
     *
     * @param ex
     * @return 返回文件名称, 便于将文件传送到服务器
     */

    public void saveCrashInfoToNet(Throwable ex) {
        StringBuffer sb = new StringBuffer();

        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        ex.printStackTrace(printWriter);
        Throwable cause = ex.getCause();
        while (cause != null) {
            cause.printStackTrace(printWriter);
            cause = cause.getCause();
        }
        printWriter.close();
        String result = writer.toString();
        sb.append(result);
        String resultStr = sb.toString();
    }

}