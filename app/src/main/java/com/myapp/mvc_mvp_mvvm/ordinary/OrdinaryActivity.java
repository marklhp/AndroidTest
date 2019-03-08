package com.myapp.mvc_mvp_mvvm.ordinary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.myapp.R;
import com.myapp.mvc_mvp_mvvm.ordinary.entry.JobInfoBean;
import com.myapp.mvc_mvp_mvvm.ordinary.entry.UserInfoBean;
import com.myapp.utils.JSONUtils;
import com.myapp.utils.httputil.HttpCallBack;
import com.myapp.utils.httputil.HttpUtils;

import java.util.concurrent.Callable;

public class OrdinaryActivity extends AppCompatActivity implements View.OnClickListener {
    TextView userinfo;
    TextView jobInfo;
    UserInfoBean userBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordinary);
        initView();
        initData();
    }



    /**
     * 初始化布局
     */
    private void initView() {
        userinfo = findViewById(R.id.ordinary_userinfo);
        jobInfo=findViewById(R.id.ordinary_jobinfo);
        initListener();
    }

    /**
     * 获取用户信息
     */
    private void initData() {
        HttpUtils.getUserInfo(new HttpCallBack<UserInfoBean>() {
            @Override
            public void call(final UserInfoBean userInfoBean) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("打印数据", JSONUtils.objectToJson(userInfoBean));
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
        findViewById(R.id.ordinary_get_user_info).setOnClickListener(this);
    }
    /**
     * 监听事件
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ordinary_get_user_info:
                changeUserInfo();
                break;
            case R.id.ordinary_user_forget:
                forget();
                break;
        }
    }

    /**
     * 用户忘记年龄了
     */
    private void forget() {
        int newAge= (int)Math.random()*100;
        newAge=newAge-(int)Math.random()*10;
        newAge=newAge-(int)Math.random()*10;
        newAge=newAge+(int)Math.random()*10;
        newAge=newAge-(int)Math.random()*10;
        newAge=newAge+(int)Math.random()*10;
        newAge=newAge-(int)Math.random()*10;
        newAge=newAge-(int)Math.random()*10;
        newAge=newAge+(int)Math.random()*10;
        newAge=newAge-(int)Math.random()*10;
        newAge=newAge-(int)Math.random()*10;
        newAge=newAge+(int)Math.random()*10;
        newAge=newAge-(int)Math.random()*10;
        newAge=newAge+(int)Math.random()*10;
        newAge=newAge-(int)Math.random()*10;

        userBean.setAge(newAge+"");
        userinfo.setText(userBean.toString());
    }

    /**
     * 更改信息
     */
    private void changeUserInfo() {
        HttpUtils.changeUserInfo(new HttpCallBack<UserInfoBean>() {
            @Override
            public void call(final UserInfoBean userInfoBean) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        userBean=userInfoBean;
                        userinfo.setText(userInfoBean.toString());
                        Log.d("打印数据1", JSONUtils.objectToJson(userInfoBean));
                    }
                });
            }
        }, new HttpCallBack<JobInfoBean>() {
            @Override
            public void call(final JobInfoBean jobInfoBean) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        jobInfo.setText(jobInfoBean.toString());
                        Log.d("打印数据2", JSONUtils.objectToJson(jobInfoBean));
                    }
                });
            }
        });
    }
}
