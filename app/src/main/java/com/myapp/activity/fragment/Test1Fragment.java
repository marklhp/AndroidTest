package com.myapp.activity.fragment;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myapp.R;
import com.myapp.base.BaseFragment;
import com.myapp.databinding.Test1FragmentBinding;
import com.myapp.utils.SkipUtils;

public class Test1Fragment extends BaseFragment<Test1FragmentBinding> implements View.OnClickListener {


    @Override
    protected int getLayoutId() {
        return R.layout.test1_fragment;
    }

    @Override
    protected void initView() {
        binding.setClick(this);
//        mActivity.getSupportFragmentManager().beginTransaction().replace(R.id.test1_fl,new Test2Fragment()).commit();

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
//        SkipUtils.skipFragment(mActivity.getSupportFragmentManager(),new Test2Fragment());
    }
}
