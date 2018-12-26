package com.myapp.mvc_mvp_mvvm.mvp3.base;

import com.myapp.source.BaseModel;
import com.myapp.source.DataModel;

public class BasePresenter<V extends BaseView,T extends BaseModel> {
    /**
     * 绑定的view
     */
    protected V mvpView;
    protected T mvpModel;

    public BasePresenter() {
        try {
            //利用反射机制获得对应Model对象的引用
            mvpModel = getModelClass().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Class<T> getModelClass(){
        return null;
    }

    /**
     * 绑定view，一般在初始化中调用该方法
     */
    public void attachView(V mvpView) {
        this.mvpView = mvpView;
    }
    /**
     * 断开view，一般在onDestroy中调用
     */
    public void detachView() {
        this.mvpView = null;
    }
    /**
     * 是否与View建立连接
     * 每次调用业务请求的时候都要出先调用方法检查是否与View建立连接
     */
    public boolean isViewAttached(){
        return mvpView != null;
    }
    /**
     * 获取连接的view
     */
    public V getView(){
        return mvpView;
    }
}
