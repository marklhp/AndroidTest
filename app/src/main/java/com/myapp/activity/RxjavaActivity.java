package com.myapp.activity;

import android.app.ActivityManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import android.provider.DocumentsContract;
import android.util.Log;
import android.view.View;

import com.myapp.R;
import com.myapp.base.BaseActivity;
import com.myapp.databinding.ActivityRxjavaBinding;
import com.myapp.utils.LogUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RxjavaActivity extends BaseActivity<ActivityRxjavaBinding> implements View.OnClickListener {

    @Override
    protected void initView() {
        binding.setClick(this);

        ActivityManager activityManager= (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo runningAppProcess : activityManager.getRunningAppProcesses()) {
            if (runningAppProcess.pid== Process.myPid()){

            }
        }
        try {
            Class<?> aClass = Class.forName("android.app.ActivityThread");
            Constructor constructor = aClass.getDeclaredConstructor();
            Object o = constructor.newInstance();
            Log.d("应用对象",o.toString());
            for (Field field : aClass.getDeclaredFields()) {
                Log.d("应用属性",field.getName());
            }
            Field sCurrentActivityThread = aClass.getDeclaredField("sCurrentActivityThread");

            sCurrentActivityThread.setAccessible(true);
            Object o1 = sCurrentActivityThread.get(o);
            Field mAppThread = aClass.getDeclaredField("mAppThread");
            mAppThread.setAccessible(true);
            Binder binder = (Binder) mAppThread.get(o1);

            binder.linkToDeath(new IBinder.DeathRecipient() {
                @Override
                public void binderDied() {
                    Log.d("应用死亡时打印","----");
                }
            },1);
            Log.d("应用","----");
        } catch (Exception e) {
            Log.d("应用死亡时==",e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_rxjava;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.rxjava_map:
                Observable.create(new ObservableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                        LogUtils.d("打印数据|"+3+"---"+Thread.currentThread().getName());
                        emitter.onNext(3);
                    }
                }).map(new Function<Integer, Boolean>() {
                    @Override
                    public Boolean apply(Integer integer) throws Exception {
                        LogUtils.d("打印数据="+integer+"---"+Thread.currentThread().getName());
                        return integer%2==0;
                    }
                }).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        LogUtils.d("打印数据-"+aBoolean+"---"+Thread.currentThread().getName());
                    }
                });
                Intent intent=new Intent();
                intent.setClass(this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.creatfile:
                String authority = "content://com.rivi.baidu.maps.MultiProcess";
                String PATH_WILDCARD = "/";   //分割符
                String path1 = "mapdata";       //对应的xml文件名
                String path2 = "commit";      //动作
                Uri uri = Uri.withAppendedPath(Uri.withAppendedPath(Uri.parse(authority), path1), path2);
                ContentValues values = new ContentValues();
                values.put("user_name", "mary");
                Cursor cursor = null;
                int result = getContentResolver().update(uri, values, null,null);
                LogUtils.d("打印保存"+result+"");
                break;
            case R.id.requestpermision:

                Intent intent1 = new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE);
                intent1.putExtra(DocumentsContract.EXTRA_INITIAL_URI, Uri.parse(path));
                // Provide read access to files and sub-directories in the user-selected
                // directory.
                intent1.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                intent1.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                startActivity(intent1);
                break;
            case R.id.getvalue:
                getvalue();
                break;

        }
    }
    String path ="/sdcard/Documents";

    private void getvalue() {
        String authority = "content://com.rivi.baidu.maps.MultiProcess";
        String PATH_WILDCARD = "/";   //分割符
        String path1 = "mapdata";       //对应的xml文件名
        String path2 = "getString";      //动作
        Uri uri = Uri.withAppendedPath(Uri.withAppendedPath(Uri.parse(authority), path1), path2);
        Cursor cursor  =  getContentResolver().query(uri, null, null,new String[]{"user_name","-"},null);
        if (cursor!=null&&cursor.getExtras()!=null){
            LogUtils.d("输出获取"+cursor.getExtras().getString("value")+"");

        }
    }

    private static final int CREATE_FILE = 1;

    private void createFile(Uri pickerInitialUri) {
        Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("application/*");
        intent.putExtra(Intent.EXTRA_TITLE, "mmkv1");

        // Optionally, specify a URI for the directory that should be opened in
        // the system file picker when your app creates the document.
        intent.putExtra(DocumentsContract.EXTRA_INITIAL_URI, pickerInitialUri);

        startActivityForResult(intent, CREATE_FILE);
    }
}
