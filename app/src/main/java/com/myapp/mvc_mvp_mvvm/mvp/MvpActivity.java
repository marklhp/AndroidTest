package com.myapp.mvc_mvp_mvvm.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.myapp.R;
import com.myapp.mvc_mvp_mvvm.ordinary.entry.JobInfoBean;
import com.myapp.mvc_mvp_mvvm.ordinary.entry.UserInfoBean;

public class MvpActivity extends AppCompatActivity implements View.OnClickListener, MvpView {

    private TextView userinfo;
    private TextView jobInfo;
    private MvpPresenter presenter;
    private UserInfoBean userBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        presenter=new MvpPresenter(this);
        initView();
        initData();
    }
    /**
     * 初始化布局
     */
    private void initView() {
        userinfo = findViewById(R.id.mvp_userinfo);
        jobInfo=findViewById(R.id.mvp_jobinfo);
        initListener();
    }
    private void initListener() {
        findViewById(R.id.mvp_get_user_info).setOnClickListener(this);
    }
    //获取信息
    private void initData() {
        presenter.getUserInfo();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mvp_get_user_info:
                //改变信息
                presenter.changeUserInfo();
                break;
            case R.id.mvp_user_forget:
                presenter.forget();
                break;
        }
    }
    @Override
    public void getUserInfoSucc(UserInfoBean userInfoBean) {
        userBean=userInfoBean;
        refreshUI();
    }

    @Override
    public void changeUserInfoSucc(UserInfoBean userInfoBean, JobInfoBean jobInfoBean) {
        userBean=userInfoBean;
        refreshUI(jobInfoBean);
    }



    @Override
    public void forgetSucc(String s) {
        userBean.setAge(s);
        refreshUI();
    }

    /**
     * 刷新数据
     * @param jobInfoBean
     */
    private void refreshUI(final JobInfoBean jobInfoBean) {
        refreshUI();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                jobInfo.setText(jobInfoBean.toString());
            }
        });
    }
    private void refreshUI() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                userinfo.setText(userBean.toString());
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
