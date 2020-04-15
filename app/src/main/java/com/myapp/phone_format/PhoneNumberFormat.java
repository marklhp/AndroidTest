package com.myapp.phone_format;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.google.i18n.phonenumbers.ShortNumberInfo;
import com.myapp.utils.PhoneUtil;

public class PhoneNumberFormat {
    private static PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
    private static ShortNumberInfo shortNumberInfo = ShortNumberInfo.getInstance();
    public static void main(String[] args){
        Phonenumber.PhoneNumber phoneNumber = null;
        try {
            phoneNumber = phoneNumberUtil.parse("+8617778115595", "");
            if (phoneNumber.getCountryCode() >-1) {

                formatNumbers(phoneNumber);

            }

            phoneNumber = phoneNumberUtil.parse("+12028710422", "");
            if (phoneNumber.getCountryCode() >-1) {

                formatNumbers(phoneNumber);

            }

            phoneNumber = phoneNumberUtil.parse("+8695555", "");
            if (phoneNumber.getCountryCode() >-1) {

                formatNumbers(phoneNumber);

            }

            phoneNumber = phoneNumberUtil.parse("+8861", "");
            if (phoneNumber.getCountryCode() >-1) {

                formatNumbers(phoneNumber);

            }

            phoneNumber = phoneNumberUtil.parse("+8685874614", "");
            if (phoneNumber.getCountryCode() >-1) {

                formatNumbers(phoneNumber);

            }

            phoneNumber = phoneNumberUtil.parse("+86031185874614", "");
            if (phoneNumber.getCountryCode() >-1) {

                formatNumbers(phoneNumber);

            }
            phoneNumber = phoneNumberUtil.parse("+861095555", "");
            if (phoneNumber.getCountryCode() >-1) {

                formatNumbers(phoneNumber);

            }
            phoneNumber = phoneNumberUtil.parse("+8601095555", "");
            if (phoneNumber.getCountryCode() >-1) {

                formatNumbers(phoneNumber);

            }


            phoneNumber = phoneNumberUtil.parse("+8601010086", "");
            if (phoneNumber.getCountryCode() >-1) {

                formatNumbers(phoneNumber);

            }
        } catch (NumberParseException e) {
            e.printStackTrace();
        }

    }

    private static void formatNumbers(Phonenumber.PhoneNumber phoneNumber) {
        String s1 = phoneNumberUtil.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.NATIONAL);

        System.out.println(phoneNumber.getNationalNumber()+"打印格式化后的号码=NATIONAL----"+s1);

        String s2 = phoneNumberUtil.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.E164);

        System.out.println(phoneNumber.getNationalNumber()+"打印格式化后的号码=E164----"+s2);


        String s3 = phoneNumberUtil.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL);

        System.out.println(phoneNumber.getNationalNumber()+"打印格式化后的号码=INTERNATIONAL----"+s3+"---"+ PhoneUtil.isValidShortChinaNumber(phoneNumber));

        String s4 = phoneNumberUtil.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.RFC3966);

        System.out.println(phoneNumber.getNationalNumber()+"打印格式化后的号码=RFC3966----"+s4);
    }
}
