package com.myapp.mvc_mvp_mvvm.mvp3;

import com.myapp.mvc_mvp_mvvm.mvp3.base.BaseView;
import com.myapp.mvc_mvp_mvvm.ordinary.entry.JobInfoBean;
import com.myapp.mvc_mvp_mvvm.ordinary.entry.UserInfoBean;

public interface Mvp3View extends BaseView {
    void getUserInfoSucc(UserInfoBean userInfoBean);
    void changeUserInfoSucc(UserInfoBean userInfoBean, JobInfoBean jobInfoBean);

}
