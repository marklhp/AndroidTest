package com.myapp.utils.httputil;

import android.os.SystemClock;

import com.myapp.mvc_mvp_mvvm.ordinary.entry.JobInfoBean;
import com.myapp.mvc_mvp_mvvm.ordinary.entry.UserInfoBean;

public class HttpUtils {
    public static void getUserInfo(final HttpCallBack<UserInfoBean> callBack) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
                UserInfoBean userInfoBean=new UserInfoBean();
                userInfoBean.setName("小恶魔");
                userInfoBean.setAge("34");
                userInfoBean.setSex("男");
                callBack.call(userInfoBean);
            }
        }).start();
    }

    public static void changeUserInfo(final HttpCallBack<UserInfoBean> callBack, final HttpCallBack<JobInfoBean> callBack1) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
                UserInfoBean userInfoBean=new UserInfoBean();
                userInfoBean.setName("提立昂.兰尼斯特爵士");
                userInfoBean.setAge("34");
                userInfoBean.setSex("男");
                callBack.call(userInfoBean);

                JobInfoBean jobInfoBean=new JobInfoBean();
                jobInfoBean.setJobName("辅佐女王");
                jobInfoBean.setStrengths("能言善辩，绝处逢生");
                jobInfoBean.setShortcoming("太矮了");
                callBack1.call(jobInfoBean);
            }
        }).start();
    }

    public static void changeUserInfo2(final HttpCallBack2<UserInfoBean,JobInfoBean> callBack) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
                UserInfoBean userInfoBean=new UserInfoBean();
                userInfoBean.setName("提立昂.兰尼斯特爵士");
                userInfoBean.setAge("34");
                userInfoBean.setSex("男");

                JobInfoBean jobInfoBean=new JobInfoBean();
                jobInfoBean.setJobName("辅佐女王");
                jobInfoBean.setStrengths("能言善辩，绝处逢生");
                jobInfoBean.setShortcoming("太矮了");
                callBack.call(userInfoBean,jobInfoBean);

            }
        }).start();
    }
}
