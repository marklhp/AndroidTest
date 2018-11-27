package com.myapp.mvc_mvp_mvvm.mvp;

import com.myapp.mvc_mvp_mvvm.ordinary.entry.JobInfoBean;
import com.myapp.mvc_mvp_mvvm.ordinary.entry.UserInfoBean;

public interface MvpView {
    void getUserInfoSucc(UserInfoBean userInfoBean);
    void changeUserInfoSucc(UserInfoBean userInfoBean, JobInfoBean jobInfoBean);

    void forgetSucc(String s);
}
