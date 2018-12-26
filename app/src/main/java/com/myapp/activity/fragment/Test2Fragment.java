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
import com.myapp.databinding.Test2FragmentBinding;
import com.myapp.utils.SkipUtils;

public class Test2Fragment extends BaseFragment<Test2FragmentBinding> implements View.OnClickListener {


    @Override
    protected int getLayoutId() {
        return R.layout.test2_fragment;
    }

    @Override
    protected void initView() {
        binding.setClick(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        SkipUtils.skipFragment(getFragmentManager(),new Test3Fragment());
    }

}
