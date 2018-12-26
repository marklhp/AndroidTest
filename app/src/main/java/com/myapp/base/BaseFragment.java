package com.myapp.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;


/**
 * Fragment的基类
 * Created by Admin on 2016/10/24.
 */
public abstract class BaseFragment<T extends ViewDataBinding> extends Fragment {
    private boolean isRegistReceiver=false;//是否注册了广播
    private BroadcastReceiver receiver;//注册的广播
    private String mClassName;//类名
    public View mRootView;//根布局
    public T binding;
    public Bundle mBundle;
    public BaseActivity mActivity;

    public BaseFragment()
    {
        mClassName=this.getClass().getSimpleName();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, getLayoutId(),container,false);
        mRootView= binding.getRoot();
        mBundle=getArguments();
        mActivity= (BaseActivity) getActivity();
        initView();
        initData();
        return mRootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (isRegistReceiver){
            receiver=null;
            isRegistReceiver=false;
        }
    }


    protected abstract int getLayoutId();
    protected abstract void initView();
    protected abstract void initData();
    public   void refresh(String data){

    }


}
