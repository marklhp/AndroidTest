package com.myapp.mvc_mvp_mvvm.mvp3;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.myapp.R;
import com.myapp.mvc_mvp_mvvm.mvp3.base.MVPBaseActivity;
import com.myapp.mvc_mvp_mvvm.ordinary.entry.JobInfoBean;
import com.myapp.mvc_mvp_mvvm.ordinary.entry.UserInfoBean;

public class Mvp3Activity extends MVPBaseActivity<Mvp3Presenter> implements Mvp3View, View.OnClickListener {
    private TextView jobInfo;
    private TextView userinfo;

    private UserInfoBean mUserInfoBean;
    private JobInfoBean mJobInfoBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp3);

        initView();
        initData();
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
