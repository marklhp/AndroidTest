package com.myapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import com.myapp.App;
import com.myapp.R;
import com.myapp.base.BaseActivity;
import com.myapp.callback.IRequestPermission;
import com.myapp.databinding.ActivityMediaPlayerBinding;
import com.myapp.utils.LogUtils;
import com.myapp.utils.PermissionUtil;

import java.util.HashMap;
import java.util.Map;

public class MediaPlayerActivity extends BaseActivity<ActivityMediaPlayerBinding> implements View.OnClickListener {


    private MediaPlayer mediaPlayer;

    @Override
    protected void initView() {
        binding.setClick(this);
        PermissionUtil.reqPermission(this, new IRequestPermission() {
            @Override
            public void accept() {

            }
        }, Manifest.permission.READ_EXTERNAL_STORAGE);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_media_player;
    }

    @Override
    public void onClick(View v) {

        playVoice();
    }

    private void playVoice() {
        try {
            Uri uri = Uri.parse("/sdcard/horse.mp3");
            Map<String, String> headers = new HashMap<>();
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(App.context, uri, headers);
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    if (mediaPlayer != null) {
                        mediaPlayer.start();

                    }


                }
            });
            mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    return false;
                }
            });
            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                @Override
                public boolean onInfo(MediaPlayer mp, int what, int extra) {
                    return false;
                }
            });

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    LogUtils.d("打印语音完成数据"+mp.isPlaying());
                }
            });
            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                @Override
                public boolean onInfo(MediaPlayer mp, int what, int extra) {
                    LogUtils.d("打印语音数据"+mp.isPlaying());

                    return false;
                }
            });
            mediaPlayer.prepareAsync();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
