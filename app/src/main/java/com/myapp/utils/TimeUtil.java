package com.myapp.utils;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TimeUtil {
    static SimpleDateFormat dateFormat3 = new SimpleDateFormat("yyyy MM-dd");
    static SimpleDateFormat dateFormat_yyyyMMdd = new SimpleDateFormat("yyyy/MM/dd");
    static SimpleDateFormat dateFormat_HH_mm = new SimpleDateFormat("HH:mm");
    public static final String formatyyyyMMdd_HHmm = "yyyy-MM-dd HH:mm:ss";
    static String[] weakDay={"日","一","二","三","四","五","六"};
    public static String formatYearMontnDay(long millisecond) {
        if (millisecond == 0) {
            return "";
        } else {
            return dateFormat3.format(millisecond);
        }
    }


    public static String getyyyyMMdd_HHmm(long millisecond) {
        return new SimpleDateFormat(formatyyyyMMdd_HHmm, Locale.US).format(millisecond);
    }

    /**
     * 获取时间
     */
    public static long getTime() {
        return new Date().getTime();
    }


    public static String formatVoiceTime(int mTime) {
        StringBuffer sb=new StringBuffer();
        sb.append(mTime/600).append(mTime/60%10).append(":").append(mTime%60/10).append(mTime%10);
        return sb.toString();

    }
    public static String formatSystemTime(String str, String str1){
        Calendar ca = Calendar.getInstance();
        int year = ca.get(Calendar.YEAR);
        int month = ca.get(Calendar.MONTH)+1;
        int day = ca.get(Calendar.DAY_OF_MONTH);
        int hour = ca.get(Calendar.HOUR_OF_DAY);
        int min = ca.get(Calendar.MINUTE);
        int s = ca.get(Calendar.SECOND);
        int m = ca.get(Calendar.MILLISECOND);
        StringBuffer sb=new StringBuffer("");
        sb.append(year).append("-").append(month).append("-").append(day).append(" ").append(hour).
                append(":").append(min).append(":").append(s).append(":").append(m).append(" ").append(str).append(" ").append(str1).append("\n");
        return sb.toString();
    }
}
