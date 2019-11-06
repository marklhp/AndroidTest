package com.myapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.myapp.R;
import com.myapp.base.BaseActivity;
import com.myapp.databinding.ActivityNdkBinding;

public class NdkActivity extends BaseActivity<ActivityNdkBinding> {
    @Override
    protected void initView() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_ndk;
    }
}
