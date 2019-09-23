package com.myapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.myapp.App;
import com.myapp.R;
import com.myapp.android_hook.HookSetOnClickListenerHelper;
import com.myapp.base.BaseActivity;
import com.myapp.databinding.ActivityAndroidHookBinding;

public class AndroidHookActivity extends BaseActivity<ActivityAndroidHookBinding> {

    @Override
    protected void initView() {
        binding.androidHookClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(App.context,"弹出内容",Toast.LENGTH_SHORT).show();
            }
        });
        HookSetOnClickListenerHelper.hook(App.context,binding.androidHookClick);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_android_hook;
    }
}
