package com.myapp.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * Created by lihaipeng on 2018/5/16.
 */

public abstract class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity {
    protected T binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         binding= DataBindingUtil.setContentView(this, getLayoutId());
         initView();
        Log.d("生命周期",this.getClass().getSimpleName()+"onCreate");
    }

    protected abstract void initView();

    public  abstract int getLayoutId() ;

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("生命周期",this.getClass().getSimpleName()+"onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("生命周期",this.getClass().getSimpleName()+"onStart");

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("生命周期",this.getClass().getSimpleName()+"onNewIntent");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("生命周期",this.getClass().getSimpleName()+"onResume");

    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d("生命周期",this.getClass().getSimpleName()+"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("生命周期",this.getClass().getSimpleName()+"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("生命周期",this.getClass().getSimpleName()+"onDestroy");

    }
}
