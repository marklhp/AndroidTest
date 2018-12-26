package com.myapp.mvc_mvp_mvvm.mvp3;

import com.myapp.mvc_mvp_mvvm.call_back.Callback;
import com.myapp.mvc_mvp_mvvm.ordinary.entry.JobInfoBean;
import com.myapp.mvc_mvp_mvvm.ordinary.entry.UserInfoBean;
import com.myapp.source.BaseModel;
import com.myapp.utils.httputil.HttpCallBack;
import com.myapp.utils.httputil.HttpCallBack2;
import com.myapp.utils.httputil.HttpUtils;

public class Mvp3Model extends BaseModel {
    public void getUserInfo(HttpCallBack<UserInfoBean> callBack) {
        HttpUtils.getUserInfo(callBack);
    }

    public void changeUserInfo( HttpCallBack2<UserInfoBean, JobInfoBean> callBack) {
        HttpUtils.changeUserInfo2(callBack);
    }

    @Override
    public void execute(Callback callback) {

    }

}
