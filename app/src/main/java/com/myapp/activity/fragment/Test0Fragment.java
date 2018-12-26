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
import com.myapp.databinding.Test0FragmentBinding;

public class Test0Fragment extends BaseFragment<Test0FragmentBinding> implements View.OnClickListener {
    Test2Fragment test2Fragment;

    @Override
    protected int getLayoutId() {
        return R.layout.test0_fragment;
    }

    @Override
    protected void initView() {
        binding.setClick(this);
        if (test2Fragment==null){
            test2Fragment=new Test2Fragment();
        }
        getFragmentManager().beginTransaction().replace(R.id.test0_fl,test2Fragment).commit();

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
    }
}
