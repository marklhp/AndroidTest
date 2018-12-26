package com.myapp.activity.fragment;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.myapp.R;
import com.myapp.base.BaseFragment;
import com.myapp.databinding.Test3FragmentBinding;

public class Test3Fragment extends BaseFragment<Test3FragmentBinding> {


    @Override
    protected int getLayoutId() {
        return R.layout.test3_fragment;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        Toast.makeText(getContext(),"toast啊",Toast.LENGTH_SHORT).show();;
    }
}
