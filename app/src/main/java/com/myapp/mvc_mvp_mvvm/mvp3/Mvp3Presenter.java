package com.myapp.mvc_mvp_mvvm.mvp3;

import com.myapp.mvc_mvp_mvvm.mvp3.base.BasePresenter;
import com.myapp.mvc_mvp_mvvm.ordinary.entry.JobInfoBean;
import com.myapp.mvc_mvp_mvvm.ordinary.entry.UserInfoBean;
import com.myapp.utils.httputil.HttpCallBack;
import com.myapp.utils.httputil.HttpCallBack2;

public class Mvp3Presenter extends BasePresenter<Mvp3View, Mvp3Model> {

    @Override
    public Class<Mvp3Model> getModelClass() {
        return Mvp3Model.class;
    }

    public void getUserInfo() {
        /**
         * 获取用户信息
         */
        mvpModel.getUserInfo(new HttpCallBack<UserInfoBean>() {
            @Override
            public void call(UserInfoBean userInfoBean) {
               if (isViewAttached()) mvpView.getUserInfoSucc(userInfoBean);
            }
        });
    }

    /**
     * 改变用户信息
     */
    public void changeUserInfo() {
        mvpModel.changeUserInfo(new HttpCallBack2<UserInfoBean, JobInfoBean>() {
            @Override
            public void call(UserInfoBean userInfoBean, JobInfoBean jobInfoBean) {
                if (isViewAttached()) mvpView.changeUserInfoSucc(userInfoBean,jobInfoBean);
            }
        });
    }

}
