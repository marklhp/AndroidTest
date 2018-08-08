package com.myapp.activity;

import android.databinding.DataBindingUtil;
import android.os.Vibrator;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.myapp.R;
import com.myapp.databinding.ActivityZxingScanBinding;

import cn.bingoogolapple.qrcode.core.QRCodeView;

public class ZxingScanActivity extends AppCompatActivity implements QRCodeView.Delegate {
    ActivityZxingScanBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_zxing_scan);
        binding.zxingScanView.startCamera();
        binding.zxingScanView.setDelegate(this);
        binding.zxingScanView.startSpotAndShowRect();
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        Toast.makeText(ZxingScanActivity.this,result,Toast.LENGTH_SHORT).show();
        vibrate();
        finish();
    }
    private void vibrate() {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);
    }
    @Override
    public void onScanQRCodeOpenCameraError() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding.zxingScanView.stopCamera();
    }
}
