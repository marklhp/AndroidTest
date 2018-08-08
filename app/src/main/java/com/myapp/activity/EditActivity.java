package com.myapp.activity;

import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.myapp.R;
import com.myapp.databinding.ActivityEditBinding;

public class EditActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityEditBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit);
        binding.setClick(this);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.focusable_tv:
                binding.focusableEt.setFocusable(!(binding.focusableEt.getFocusable()==View.FOCUSABLE));
                break;
        }
        Log.v("-----======",""+v.getId());
    }
}
