package com.myapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.google.i18n.phonenumbers.ShortNumberInfo;
import com.google.i18n.phonenumbers.ShortNumbersRegionCodeSet;
import com.myapp.R;
import com.myapp.base.BaseActivity;
import com.myapp.databinding.ActivityPhoneBinding;

public class PhoneActivity extends BaseActivity<ActivityPhoneBinding> {


    @Override
    protected void initView() {
        PhoneNumberUtil phoneNumberUtil= PhoneNumberUtil.getInstance();
        try {
            Phonenumber.PhoneNumber phoneNumber = phoneNumberUtil.parse("2028710422", "1");

            int code =phoneNumber.getCountryCode();
            long number=phoneNumber.getNationalNumber();

            boolean validNumber = phoneNumberUtil.isValidNumber(phoneNumber);
            Toast.makeText(this,code+"---"+number+"---"+String.valueOf(validNumber),Toast.LENGTH_SHORT).show();
            ShortNumberInfo info= ShortNumberInfo.getInstance();
            info.isValidShortNumber(phoneNumber);
            Toast.makeText(this,""+info.isValidShortNumber(phoneNumber),Toast.LENGTH_SHORT).show();
        } catch (NumberParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_phone;
    }
}
