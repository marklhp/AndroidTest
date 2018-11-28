package com.myapp.activity;


import android.view.View;

import com.myapp.R;
import com.myapp.base.BaseActivity;
import com.myapp.databinding.ActivityAccessibilityServiceBinding;
import com.myapp.service.AccessibilityOperator;
import com.myapp.service.OpenAccessibilitySettingHelper;

public class AccessibilityServiceActivity extends BaseActivity<ActivityAccessibilityServiceBinding> implements View.OnClickListener {



    @Override
    public int getLayoutId() {
        return R.layout.activity_accessibility_service;
    }
    @Override
    protected void initView() {
        binding.setClick(this);
        AccessibilityOperator.getInstance().init(this);
        getViewData();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.accessibility_tv:
                OpenAccessibilitySettingHelper.jumpToSettingPage(this);
                break;
        }
    }
    private void getViewData() {


    }
}
