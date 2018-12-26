package com.myapp.activity.jetpack;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myapp.R;
import com.myapp.base.BaseFragment;
import com.myapp.databinding.FragmentJetpack2Binding;
import com.myapp.model.UserBean;
import com.myapp.utils.DeviceUtils;

import androidx.lifecycle.Observer;

/**
 * A simple {@link Fragment} subclass.
 */
public class Jetpack2Fragment extends BaseFragment<FragmentJetpack2Binding> implements View.OnClickListener {
    public static Jetpack2Fragment newInstance() {
        return new Jetpack2Fragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_jetpack2;
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
        JetpackModel.getUser().observe(this, new Observer<UserBean>() {
            @Override
            public void onChanged(UserBean userBean) {
                binding.setUser(userBean);
            }
        });
        DeviceUtils.isMiui();
    }
}
