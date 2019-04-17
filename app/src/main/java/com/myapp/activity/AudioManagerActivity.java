package com.myapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import com.myapp.R;
import com.myapp.base.BaseActivity;
import com.myapp.databinding.ActivityAudioManagerBinding;

/**
 * 音频管理器使用
 */
public class AudioManagerActivity extends BaseActivity<ActivityAudioManagerBinding> {

    @Override
    public int getLayoutId() {
        return R.layout.activity_audio_manager;
    }
    @Override
    protected void initView() {

    }
}
