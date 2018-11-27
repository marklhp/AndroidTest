package com.myapp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.myapp.R;


public class DelayedUIActivity extends Activity implements View.OnClickListener {

    TextView delayedUiTv;
    TextView delayedUiTv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delayed_ui);
        delayedUiTv=findViewById(R.id.delayed_ui_tv);
        delayedUiTv2=findViewById(R.id.delayed_ui_tv2);
        delayedUiTv.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.delayed_ui_tv:
                Toast.makeText(this, "dianji----", Toast.LENGTH_SHORT).show();
                SystemClock.sleep(3000);
                Toast.makeText(this, "dianji", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
