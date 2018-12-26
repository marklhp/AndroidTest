package com.myapp.mvc_mvp_mvvm.mvp2;

import com.myapp.mvc_mvp_mvvm.ordinary.entry.JobInfoBean;
import com.myapp.mvc_mvp_mvvm.ordinary.entry.UserInfoBean;

public interface Mvp2View {
    void getUserInfoSucc(UserInfoBean userInfoBean);
    void changeUserInfoSucc(UserInfoBean userInfoBean, JobInfoBean jobInfoBean);

}
