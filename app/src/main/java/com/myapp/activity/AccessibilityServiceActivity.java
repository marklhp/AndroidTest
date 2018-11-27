package com.myapp.activity;


import android.view.View;

import com.myapp.R;
import com.myapp.base.BaseActivity;
import com.myapp.databinding.ActivityAccessibilityServiceBinding;

public class AccessibilityServiceActivity extends BaseActivity<ActivityAccessibilityServiceBinding> implements View.OnClickListener {



    @Override
    public int getLayoutId() {
        return R.layout.activity_accessibility_service;
    }
    @Override
    protected void initView() {
        binding.setClick(this);
    }

    @Override
    public void onClick(View v) {

    }
}
