package com.myapp.activity.navigation;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myapp.R;
import com.myapp.base.BaseFragment;
import com.myapp.databinding.FragmentSecondBinding;

import androidx.navigation.Navigation;


public class SecondFragment extends BaseFragment<FragmentSecondBinding> implements View.OnClickListener {


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_second;
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
        switch (v.getId()){
            case R.id.btn_back:
                Navigation.findNavController(v).navigateUp();
                break;
        }
    }
}
