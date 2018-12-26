package com.myapp.mvc_mvp_mvvm.mvp2;

import com.myapp.mvc_mvp_mvvm.mvp.MvpModel;
import com.myapp.mvc_mvp_mvvm.ordinary.entry.JobInfoBean;
import com.myapp.mvc_mvp_mvvm.ordinary.entry.UserInfoBean;
import com.myapp.utils.httputil.HttpCallBack;
import com.myapp.utils.httputil.HttpCallBack2;

public class Mvp2Presenter {
    // View接口
    private Mvp2View mView;
    private Mvp2Model mvp2Model;
    public Mvp2Presenter(){
    //构造方法中不再需要View参数
        mvp2Model=new Mvp2Model();
    }
    /**
     * 绑定view，一般在初始化中调用该方法
     */
    public void attachView(Mvp2View  mvpView) {
        this.mView= mvpView;
    }
    /**
     * 断开view，一般在onDestroy中调用
     */
    public void detachView() {
        this.mView= null;
    }
    /**
     * 是否与View建立连接
     * 每次调用业务请求的时候都要出先调用方法检查是否与View建立连接
     */
    public boolean isViewAttached(){
        return mView!= null;
    }

    /**
     * 获取用户信息
     */
    public void getUserInfo() {
        mvp2Model.getUserInfo(new HttpCallBack<UserInfoBean>() {
            @Override
            public void call(UserInfoBean userInfoBean) {
                if (isViewAttached()) mView.getUserInfoSucc(userInfoBean);
            }
        });

    }

    /**
     * 修改年龄并获取用户工作信息
     */
    public void changeUserInfo() {
        mvp2Model.changeUserInfo(new HttpCallBack2<UserInfoBean, JobInfoBean>() {
            @Override
            public void call(UserInfoBean userInfoBean, JobInfoBean jobInfoBean) {
                if (isViewAttached()) mView.changeUserInfoSucc(userInfoBean,jobInfoBean);
            }
        });
    }

}
