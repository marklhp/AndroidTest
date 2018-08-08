package com.myapp.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.myapp.R;
import com.myapp.databinding.ActivityFragmentBinding;
import com.myapp.fragment.LifeFragment1;
import com.myapp.fragment.LifeFragment2;

public class FragmentActivity extends AppCompatActivity implements View.OnClickListener {
    LifeFragment1 fragment1=new LifeFragment1();
    LifeFragment2 fragment2=new LifeFragment2();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFragmentBinding binding=DataBindingUtil.setContentView(this,R.layout.activity_fragment);
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
