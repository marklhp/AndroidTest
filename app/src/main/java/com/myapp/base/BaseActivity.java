package com.myapp.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

import com.myapp.R;
import com.myapp.databinding.ActivityDataBindingGlideBinding;

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
    }

    protected abstract void initView();

    public  abstract int getLayoutId() ;
}
