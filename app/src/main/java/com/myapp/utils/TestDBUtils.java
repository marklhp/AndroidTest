package com.myapp.utils;

import android.text.TextUtils;

public class TestDBUtils {

    public static String getUserName(String userid){
        if (TextUtils.equals(userid,"user_id")){
            return "刘烨";
        }else {
            return "";
        }
    }
}
