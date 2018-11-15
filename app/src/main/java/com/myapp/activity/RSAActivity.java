package com.myapp.activity;

import android.app.Activity;
import android.os.Bundle;

import com.myapp.R;

public class RSAActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsa);
        String data = "hello world";
    }

}
