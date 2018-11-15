package com.myapp.activity;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.myapp.R;
import com.myapp.databinding.ActivityFragmentBinding;
import com.myapp.fragment.LifeFragment1;
import com.myapp.fragment.LifeFragment2;

import androidx.databinding.DataBindingUtil;

public class MyFragmentActivity extends FragmentActivity implements View.OnClickListener {
    LifeFragment1 fragment1=new LifeFragment1();
    LifeFragment2 fragment2=new LifeFragment2();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFragmentBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_fragment);
        binding.setClick(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.life_tv1:
                getSupportFragmentManager().beginTransaction().replace(R.id.life_fl,fragment1).commit();
                break;
            case R.id.life_tv2:
                getSupportFragmentManager().beginTransaction().replace(R.id.life_fl,fragment2).commit();
                break;
        }
    }
}
