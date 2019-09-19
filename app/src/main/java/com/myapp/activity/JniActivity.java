package com.myapp.activity;

import android.util.Log;
import android.view.View;

import com.myapp.R;
import com.myapp.base.BaseActivity;
import com.myapp.databinding.ActivityJniBinding;
import com.myapp.ndk.NdkTools;

public class JniActivity extends BaseActivity<ActivityJniBinding> implements View.OnClickListener {


    @Override
    protected void initView() {
        binding.setClick(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_jni;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.javaToJni:

                Log.d("打印jni数据", NdkTools.stringFromJNI());
                break;

            case R.id.jniToJava:

                break;
        }
    }

}
