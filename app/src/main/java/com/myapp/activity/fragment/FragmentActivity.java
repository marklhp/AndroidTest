package com.myapp.activity.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.myapp.R;
import com.myapp.base.BaseActivity;
import com.myapp.databinding.ActivityFragment2Binding;

public class FragmentActivity extends BaseActivity<ActivityFragment2Binding> implements View.OnClickListener {


    @Override
    protected void initView() {
        binding.setClick(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_fl,new Test0Fragment()).commit();

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_fragment2;
    }

    @Override
    public void onClick(View v) {
    }
}
