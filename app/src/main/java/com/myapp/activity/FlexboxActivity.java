package com.myapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.myapp.R;
import com.myapp.base.BaseActivity;
import com.myapp.databinding.ActivityFlexboxBinding;
import com.myapp.utils.LogUtils;

public class FlexboxActivity extends BaseActivity<ActivityFlexboxBinding> {



    @Override
    protected void initView() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_flexbox;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        LogUtils.d("打印按键信息"+keyCode+"---"+event.getAction()+"==="+event.getScanCode());
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        LogUtils.d("打印触摸信息"+event.getPressure()+"---"+event.getAction()+"==="+event.getX()+"---"+event.getPointerCount());
        return super.onTouchEvent(event);
    }
}
