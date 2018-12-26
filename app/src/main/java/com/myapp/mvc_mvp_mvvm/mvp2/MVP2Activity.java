package com.myapp.mvc_mvp_mvvm.mvp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.myapp.R;
import com.myapp.mvc_mvp_mvvm.ordinary.entry.JobInfoBean;
import com.myapp.mvc_mvp_mvvm.ordinary.entry.UserInfoBean;

public class MVP2Activity extends AppCompatActivity implements Mvp2View , View.OnClickListener {
    Mvp2Presenter presenter;

    private TextView jobInfo;
    private TextView userinfo;

    private UserInfoBean mUserInfoBean;
    private JobInfoBean mJobInfoBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp2);
        presenter=new Mvp2Presenter();
        initView();
        initData();
    }

    /**
     * 界面可见并获取焦点
     */
    @Override
    protected void onResume() {
        super.onResume();
        //view与presenter绑定
        presenter.attachView(this);
    }

    /**
     * 界面失去焦点
     */
    @Override
    protected void onPause() {
        super.onPause();
        //view与presenter解绑
        presenter.detachView();
    }
    /**
     * 初始化布局
     */
    private void initView() {
        userinfo = findViewById(R.id.mvp2_userinfo);
        jobInfo=findViewById(R.id.mvp2_jobinfo);
        initListener();
    }
    private void initListener() {
        findViewById(R.id.mvp_get_user_info).setOnClickListener(this);
    }

    /**
     * 获取信息
     */
    private void initData() {
        presenter.getUserInfo();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mvp2_get_user_info:
                //改变信息
                presenter.changeUserInfo();
                break;
        }
    }

    /**
     * 获取用户信息成功
     * @param userInfoBean
     */
    @Override
    public void getUserInfoSucc(UserInfoBean userInfoBean) {
        mUserInfoBean =userInfoBean;
        refreshUI();
    }

    /**
     * 修改用户信息成功
     * @param userInfoBean
     * @param jobInfoBean
     */
    @Override
    public void changeUserInfoSucc(UserInfoBean userInfoBean, JobInfoBean jobInfoBean) {
        mUserInfoBean =userInfoBean;
        mJobInfoBean=jobInfoBean;
        refreshUI();
    }

    /**
     * 刷新数据
     */
    private void refreshUI() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mUserInfoBean !=null) userinfo.setText(mUserInfoBean.toString());
                if (jobInfo !=null) jobInfo.setText(mJobInfoBean.toString());
            }
        });
    }

}
