package com.myapp.mvc_mvp_mvvm.mvp;

import com.myapp.mvc_mvp_mvvm.ordinary.entry.JobInfoBean;
import com.myapp.mvc_mvp_mvvm.ordinary.entry.UserInfoBean;
import com.myapp.utils.httputil.HttpCallBack;
import com.myapp.utils.httputil.HttpCallBack2;
import com.myapp.utils.httputil.ModelCallBack;

public class MvpPresenter {
    MvpView mvpView;
    MvpModel mvpModel;

    public MvpPresenter(MvpView mvpView) {
        this.mvpView = mvpView;
        this.mvpModel=new MvpModel();
    }

    public void changeUserInfo() {
        mvpModel.changeUserInfo(new HttpCallBack2<UserInfoBean, JobInfoBean>() {
            @Override
            public void call(UserInfoBean userInfoBean, JobInfoBean jobInfoBean) {
                mvpView.changeUserInfoSucc(userInfoBean,jobInfoBean);
            }
        });
    }

    public void forget() {
        mvpModel.forger(new ModelCallBack<String>() {
            @Override
            public void call(String s) {
                mvpView.forgetSucc(s);
            }
        });
    }

    public void getUserInfo() {
        mvpModel.getUserInfo(new HttpCallBack<UserInfoBean>() {
            @Override
            public void call(UserInfoBean userInfoBean) {
                mvpView.getUserInfoSucc(userInfoBean);
            }
        });
    }
}
