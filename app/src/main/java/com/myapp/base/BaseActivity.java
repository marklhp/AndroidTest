package com.myapp.base;

import android.app.Activity;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * Created by lihaipeng on 2018/5/16.
 */

public abstract class BaseActivity<T extends ViewDataBinding> extends Activity {
    protected T binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         binding= DataBindingUtil.setContentView(this, getLayoutId());
         initView();
    }

    protected abstract void initView();

    public  abstract int getLayoutId() ;
}
