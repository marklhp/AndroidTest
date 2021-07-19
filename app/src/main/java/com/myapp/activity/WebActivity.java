package com.myapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.myapp.R;
import com.myapp.base.BaseActivity;
import com.myapp.customview.ProgressWebView;
import com.myapp.databinding.ActivityWebBinding;
import com.myapp.utils.DeviceUtils;
import com.myapp.utils.LogUtils;

import java.util.HashMap;

import static android.webkit.WebSettings.LOAD_NO_CACHE;

public class WebActivity extends BaseActivity<ActivityWebBinding> implements View.OnClickListener {

    String url;
    @SuppressLint({"JavascriptInterface", "SetJavaScriptEnabled"})
    @Override
    protected void initView() {
        initWebView();
        binding.setClick(this);
        if (getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        String s="jfa;djadfa;";

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_web;
    }








    @SuppressLint("SetJavaScriptEnabled")
    private void initWebView() {


        binding.flView.getSettings().setJavaScriptEnabled(true);
//        this.mWebView.getSettings().setCacheMode(LOAD_NO_CACHE);
//        this.mWebView.getSettings().setUseWideViewPort(true);
//        this.mWebView.getSettings().setLoadWithOverviewMode(true);
//        this.mWebView.getSettings().setDomStorageEnabled(true);
//        this.mWebView.getSettings().setBuiltInZoomControls(true);

        binding.flView.addJavascriptInterface(this, "Android");
    }


    @JavascriptInterface
    public void getLoginMsg() {
        LogUtils.d("找回密码getLoginMsg");
        finish();
    }

    @JavascriptInterface
    public void sendRegisteResultMsg(String paramString) {
        LogUtils.d("找回密码sendRegisteResultMsg");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.url1:
                url=binding.url1.getText().toString();
                binding.url1.setTextColor(getResources().getColor(android.R.color.holo_orange_light));
                binding.url2.setTextColor(getResources().getColor(android.R.color.black));
                break;
            case R.id.url2:
                url=binding.url2.getText().toString();
                binding.url1.setTextColor(getResources().getColor(android.R.color.black));
                binding.url2.setTextColor(getResources().getColor(android.R.color.holo_orange_light));
                break;
        }
        url="https://accounts.google.com/signin/v2/identifier?service=accountsettings&continue=https%3A%2F%2Fmyaccount.google.com%2F&csig=AF-SEnYKj7IhH1gJw6ve%3A1578992372&flowName=GlifWebSignIn&flowEntry=AddSession";
        binding.flView.loadUrl(url);
    }
}
