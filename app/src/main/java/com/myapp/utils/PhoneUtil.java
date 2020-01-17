package com.myapp.utils;


import android.text.TextUtils;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberToCarrierMapper;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.google.i18n.phonenumbers.ShortNumberInfo;
import com.google.i18n.phonenumbers.geocoding.PhoneNumberOfflineGeocoder;

import java.util.Locale;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class PhoneUtil {
    private static PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();

    private static PhoneNumberToCarrierMapper carrierMapper = PhoneNumberToCarrierMapper.getInstance();

    private static PhoneNumberOfflineGeocoder geocoder = PhoneNumberOfflineGeocoder.getInstance();

    private static ShortNumberInfo shortNumberInfo = ShortNumberInfo.getInstance();



    public static Phonenumber.PhoneNumber getPhoneNumber(String fullNumber) {
        return getPhoneNumber(fullNumber, false);
    }

    public static Phonenumber.PhoneNumber getPhoneNumber(String phoneNumber, boolean isUSA) {
        Phonenumber.PhoneNumber pn = null;
        if (isUSA) {
            try {
                pn = phoneNumberUtil.parse(phoneNumber, null);
            } catch (NumberParseException e) {
            }
        } else {
            try {
                pn = phoneNumberUtil.parse(phoneNumber, null);
            } catch (NumberParseException e) {
            }
        }
        return pn;
    }

    /**
     * 根据国家代码和手机号  判断手机运营商
     *
     * @param phoneNumber
     * @param countryCode
     * @return
     */
    public static String getCarrier(String phoneNumber, String countryCode) {

        int ccode = toInteger(countryCode);
        long phone = toLong(phoneNumber, 0L);

        Phonenumber.PhoneNumber pn = new Phonenumber.PhoneNumber();
        pn.setCountryCode(ccode);
        pn.setNationalNumber(phone);
        //返回结果只有英文，自己转成成中文
        String carrierEn = carrierMapper.getNameForNumber(pn, Locale.ENGLISH);
        String carrierZh = "";
        carrierZh += geocoder.getDescriptionForNumber(pn, Locale.CHINESE);
        switch (carrierEn) {
            case "China Mobile":
                carrierZh += "移动";
                break;
            case "China Unicom":
                carrierZh += "联通";
                break;
            case "China Telecom":
                carrierZh += "电信";
                break;
            default:
                break;
        }
        return carrierZh;
    }


    /**
     * @param @param  phoneNumber
     * @param @param  countryCode
     * @param @return 参数
     * @throws
     * @Description: 根据国家代码和手机号  手机归属地
     * @date 2015-7-13 上午11:33:18
     */
    public static String getGeo(String phoneNumber, String countryCode) {

        int ccode = toInteger(countryCode);
        long phone = toLong(phoneNumber, 0L);

        Phonenumber.PhoneNumber pn = new Phonenumber.PhoneNumber();
        pn.setCountryCode(ccode);
        pn.setNationalNumber(phone);

        return geocoder.getDescriptionForNumber(pn, Locale.CHINESE);

    }

    private static long toLong(String phoneNumber, long l) {
        try {
            return Long.parseLong(phoneNumber);
        } catch (Exception e) {
            return l;
        }
    }

    private static int toInteger(String countryCode) {
        try {
            return Integer.parseInt(countryCode);
        } catch (Exception e) {
            return 0;
        }
    }


    public static boolean checkPhoneNumber(Phonenumber.PhoneNumber phoneNumber) {
        boolean validNumber = false;
        try {
            if (phoneNumberUtil != null && phoneNumber != null) {
                validNumber = phoneNumberUtil.isValidNumber(phoneNumber);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return validNumber;
    }

    /**
     * 将美加号码做格式化处理 比如：+1(123)456-7890
     *
     * @param s
     * @return
     */
    public static String format(String s) {
        try {
            Phonenumber.PhoneNumber phoneNumber = phoneNumberUtil.parse(s, "");
            if (phoneNumber!=null&&phoneNumber.getCountryCode()>0){
                String s1 = phoneNumberUtil.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.NATIONAL);
                return "+" + phoneNumber.getCountryCode()+" "+ s1;
            }else {
                return "";
            }

        } catch (Exception e) {
            return "";
        }
    }



    /**
     * 将美加号码做格式化处理 比如：+1(123)456-7890
     *
     * @param s
     * @return
     */
    public static String format(String s,PhoneNumberUtil.PhoneNumberFormat format) {
        try {
            Phonenumber.PhoneNumber phoneNumber = phoneNumberUtil.parse(s, "");
            if (phoneNumber!=null&&phoneNumber.getCountryCode()>0){
                String s1 = phoneNumberUtil.format(phoneNumber, format);
                return "+" + phoneNumber.getCountryCode()+" "+ s1;
            }else {
                return "";
            }

        } catch (Exception e) {
            return "";
        }
    }
    /**
     * 判断号码是否合法
     *
     * @param phoneNumber
     * @return
     */
    public static boolean isValidNumber(Phonenumber.PhoneNumber phoneNumber) {
        boolean flag = false;
        try {
            flag = phoneNumberUtil.isValidNumber(phoneNumber);
            if (!flag){
                try {
                    ShortNumberInfo shortNumberInfo = ShortNumberInfo.getInstance();
                    flag=shortNumberInfo.isValidShortNumber(phoneNumber);

                }catch (Exception e1){}
            }
        } catch (Exception e) {

        }
        return flag;
    }
    /**
     * 判断长号码号码是否合法
     *
     * @param phoneNumber
     * @return
     */
    public static boolean isValidLongNumber(Phonenumber.PhoneNumber phoneNumber) {
        boolean flag = false;
        try {
            flag = phoneNumberUtil.isValidNumber(phoneNumber);
        } catch (Exception e) {

        }
        return flag;
    }
    /**
     * 判断短号码是否合法
     *
     * @param phoneNumber
     * @return
     */
    public static boolean isValidShortChinaNumber(Phonenumber.PhoneNumber phoneNumber) {
        boolean flag = false;
        try {
            try {

                flag=shortNumberInfo.isValidShortNumber(phoneNumber)||shortNumberInfo.isPossibleShortNumber(phoneNumber);


                if (flag){
                    flag=phoneNumber.getCountryCode()==86;
                }
            }catch (Exception e1){}
        } catch (Exception e) {

        }
        return flag;
    }

    /**
     * 获取区域码
     * @return
     * @param phoneNumber
     */
    public static String getRegionCode(Phonenumber.PhoneNumber phoneNumber){
        try {
            return geocoder.getDescriptionForNumber(phoneNumber, Locale.CHINA);
        }catch (Exception e){
            return "";
        }

    }

    public static String getCountryCode(String number) {
        String code = null;
        try {
            Phonenumber.PhoneNumber phoneNumber =phoneNumberUtil.parse(number,"1");
            code=phoneNumberUtil.getRegionCodeForNumber(phoneNumber);
        }catch (Exception e){
            e.printStackTrace();
        }
        return code;
    }
}
