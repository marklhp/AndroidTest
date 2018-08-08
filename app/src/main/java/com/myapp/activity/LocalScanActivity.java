package com.myapp.activity;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

import com.myapp.R;
import com.myapp.service.ServiceActivity;
import com.seuic.scanner.DecodeInfo;
import com.seuic.scanner.DecodeInfoCallBack;
import com.seuic.scanner.Scanner;
import com.seuic.scanner.ScannerFactory;
import com.seuic.scanner.ScannerKey;
import com.seuic.scanner.VideoCallBack;

public class LocalScanActivity extends AppCompatActivity implements DecodeInfoCallBack, VideoCallBack {
    static final String TAG = "ScannerApiTest";
    Scanner scanner;
    private static ServiceActivity mcontext = null;
    public static final String BAR_CODE = "barcode";
    public static final String CODE_TYPE = "codetype";
    public static final String LENGTH = "length";
    public static final String ACTION = "seuic.android.scanner.scannertestreciever";
    private boolean mScanRunning = false;


    private  void log(String  string){
        Log.i(TAG, string);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_scan);

    }

    @Override
    protected void onResume() {
        super.onResume();
        scanner = ScannerFactory.getScanner(this);
        scanner.open();
        scanner.setDecodeInfoCallBack(this);
        scanner.setVideoCallBack(this);
        scanner.enable();
        mScanRunning = true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==142) scanner.startScan();
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode==142) scanner.stopScan();
        return super.onKeyUp(keyCode, event);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mScanRunning = false;
        ScannerKey.close();
        scanner.setDecodeInfoCallBack(null);
        scanner.setVideoCallBack(null);
        scanner.close();
        scanner = null;
    }


    // this is a custom broadcast receiver action


    @Override
    public void onDecodeComplete(DecodeInfo info) {
        Intent intent = new Intent(ACTION);
        Bundle bundle = new Bundle();
        bundle.putString(BAR_CODE, info.barcode);
        bundle.putString(CODE_TYPE, info.codetype);
        bundle.putInt(LENGTH, info.length);
        intent.putExtras(bundle);
        sendBroadcast(intent);
        Toast.makeText(this,info.barcode,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onVideoCallBack(int width, int height, byte[] img) {
        if (img == null||width == 0||height == 0||img.length == 0){
            return false;
        }

        log("onVideCallBack E");
        Message video_msg = mcontext.mHandler.obtainMessage(img.length, width, height, img);
        mcontext.mHandler.sendMessage(video_msg);

        try {
            Thread.sleep(80);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log("onVideCallBack X");

        return false;
    }

}
