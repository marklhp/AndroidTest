package com.myapp.utils;

import android.text.TextUtils;
import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class MessageDataAnalysisUtils {
    static String messagepass="";
    static StringBuffer stringBuffer;
    static ArrayList<Integer> list2=new ArrayList<>();
    private static final String specialChar1="\\_\\*\\_\\*";
    private static final String specialChar2="^*";
    private static final String specialChar3="#&#&";

    public static void dataAnalySis(){
        String userid="#&#&user_id#&#&";
        System.out.println("加密前的数据=="+"就是这个问题_*_*^*"+userid+"^*_*_*倒是你看看");
        messagepass="就是这个问题_*_*^*"+Base64.encodeToString(userid.getBytes(),Base64.DEFAULT)+"^*_*_*倒是你看看";
        System.out.println("加密了的数据｜｜｜"+messagepass);
        stringBuffer=new StringBuffer("");
        String[] split = messagepass.split(specialChar1);
        if (split!=null){
            for (String s : split) {
                if (s.contains(specialChar2)){
                    String substring = s.substring(2);
                    substring=substring.substring(0,substring.length()-2);
                    System.out.println("测试数据打印"+substring);
                    String string = null;
                    try {
                        string = new String(Base64.decode(substring,Base64.DEFAULT), "US-ASCII");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    if (string.contains(specialChar3)){
                        System.out.println("测试数据打印---"+string);

                        String substring1 = string.substring(4);
                        substring1=substring1.substring(0,substring1.length()-4);
                        String userName=TestDBUtils.getUserName(substring1);
                        if (!TextUtils.isEmpty(userName)){

                            stringBuffer.append("@").append(userName);
                        }else {
                            stringBuffer.append(s);
                        }
                    }else {
                        stringBuffer.append(s);
                    }

                }else {
                    stringBuffer.append(s);
                }
            }
        }

        System.out.println("解密了的数据｜｜"+stringBuffer.toString());
    }
}
