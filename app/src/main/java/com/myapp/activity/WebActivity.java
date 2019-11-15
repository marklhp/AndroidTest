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
import com.myapp.databinding.ActivityWebBinding;
import com.myapp.utils.DeviceUtils;
import com.myapp.utils.LogUtils;

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

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_web;
    }



    private WebView mWebView;





    @SuppressLint("SetJavaScriptEnabled")
    private void initWebView() {
        this.mWebView = new WebView(this);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
//        this.mWebView.getSettings().setCacheMode(LOAD_NO_CACHE);
//        this.mWebView.getSettings().setUseWideViewPort(true);
//        this.mWebView.getSettings().setLoadWithOverviewMode(true);
//        this.mWebView.getSettings().setDomStorageEnabled(true);
//        this.mWebView.getSettings().setBuiltInZoomControls(true);

        this.mWebView.addJavascriptInterface(this, "Android");
        binding.flView.addView(mWebView);
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
        mWebView.loadUrl(url);
    }
}
