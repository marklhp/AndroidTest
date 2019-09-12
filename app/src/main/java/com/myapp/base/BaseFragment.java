package com.myapp.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
public abstract class BaseFragment<T extends ViewDataBinding> extends Fragment implements View.OnLayoutChangeListener {
    private boolean isRegistReceiver=false;//是否注册了广播
    private BroadcastReceiver receiver;//注册的广播
    private String mClassName;//类名
    public View mRootView;//根布局
    public T binding;
    public Bundle mBundle;
    public BaseActivity mActivity;
    private String TAG="";

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




    protected abstract int getLayoutId();
    protected abstract void initView();
    protected abstract void initData();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        TAG="生命周期"+getClass().getSimpleName();
        Log.d(TAG,"onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG,"onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");


        binding.getRoot().addOnLayoutChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG,"onDestroyView");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
        if (isRegistReceiver){
            receiver=null;
            isRegistReceiver=false;
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG,"onDetach");
    }

    @Override
    public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        int[] location = new  int[2] ;
//        binding.getRoot().getLocationInWindow(location); //获取在当前窗口内的绝对坐标
        binding.getRoot().getLocationOnScreen(location);//获取在整个屏幕内的绝对坐标
        Log.d(TAG,"onResume"+"view--->x坐标:"+location [0]+"view--->y坐标:"+location [1]);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d(TAG,"setUserVisibleHint="+String.valueOf(isVisibleToUser));
    }
}
