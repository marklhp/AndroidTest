package com.myapp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.myapp.R;
import com.myapp.databinding.TestLayoutBinding;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DelayedUIActivity extends Activity {

    @BindView(R.id.delayed_ui_tv)
    TextView delayedUiTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delayed_ui);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.delayed_ui_tv)
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.delayed_ui_tv:
                SystemClock.sleep(2500);
                Toast.makeText(this,"dianji",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
