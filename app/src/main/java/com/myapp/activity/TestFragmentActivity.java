package com.myapp.activity;

import android.view.View;

import com.myapp.R;
import com.myapp.adapter.FragmentAdapter;
import com.myapp.base.BaseActivity;
import com.myapp.databinding.ActivityTestFragmentBinding;

public class TestFragmentActivity extends BaseActivity<ActivityTestFragmentBinding> implements View.OnClickListener {


    @Override
    protected void initView() {
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        binding.testFragmentVp.setAdapter(adapter);
        binding.setClick(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_test_fragment;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.test_fragment_tv0:
                binding.testFragmentVp.setCurrentItem(0);
                break;
            case R.id.test_fragment_tv1:
                binding.testFragmentVp.setCurrentItem(1);
                break;
            case R.id.test_fragment_tv2:
                binding.testFragmentVp.setCurrentItem(2);
                break;
            case R.id.test_fragment_tv3:
                binding.testFragmentVp.setCurrentItem(3);
                break;

        }
    }
}
