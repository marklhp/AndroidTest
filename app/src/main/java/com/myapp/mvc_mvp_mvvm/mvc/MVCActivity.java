package com.myapp.mvc_mvp_mvvm.mvc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.myapp.R;
import com.myapp.mvc_mvp_mvvm.ordinary.entry.JobInfoBean;
import com.myapp.mvc_mvp_mvvm.ordinary.entry.UserInfoBean;
import com.myapp.utils.httputil.HttpCallBack;
import com.myapp.utils.httputil.ModelCallBack;

public class MVCActivity extends AppCompatActivity implements View.OnClickListener {
    private MVCModel mvcModel;
    private TextView userinfo;
    private TextView jobInfo;
    UserInfoBean userBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        mvcModel=new MVCModel();
        initView();
        initData();
    }

    /**
     * 初始化布局
     */
    private void initView() {
        userinfo = findViewById(R.id.mvc_userinfo);
        jobInfo=findViewById(R.id.mvc_jobinfo);
        initListener();
    }

    /**
     * 获取用户信息
     */
    private void initData() {
        mvcModel.getUserInfo(new HttpCallBack<UserInfoBean>() {
            @Override
            public void call(final UserInfoBean userInfoBean) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        userBean=userInfoBean;
                        userinfo.setText(userBean.toString());
                    }
                });
            }
        });
    }
    /**
     * 初始化监听事件
     */
    private void initListener() {
        findViewById(R.id.mvc_get_user_info).setOnClickListener(this);
    }
    /**
     * 监听事件
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mvc_get_user_info:
                changeUserInfo();
                break;
            case R.id.mvc_user_forget:
                forget();
                break;
        }
    }

    private void forget() {
        mvcModel.forger(new ModelCallBack<String>() {
            @Override
            public void call(String s) {
                userBean.setAge(s);
                userinfo.setText(userBean.toString());
            }
        });
    }

    /**
     * 更改信息
     */
    private void changeUserInfo() {
        //activity 作为参数传入，持有事件不明确，易导致内存泄漏
        mvcModel.changeUserInfo(this, new HttpCallBack<UserInfoBean>() {
            @Override
            public void call(UserInfoBean userInfoBean) {
                userBean=userInfoBean;
                userinfo.setText(userInfoBean.toString());
            }
        }, new HttpCallBack<JobInfoBean>() {
            @Override
            public void call(JobInfoBean jobInfoBean) {
                jobInfo.setText(jobInfoBean.toString());
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
