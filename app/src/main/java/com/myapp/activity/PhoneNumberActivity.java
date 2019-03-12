package com.myapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.myapp.R;
import com.myapp.base.BaseActivity;
import com.myapp.databinding.ActivityPhoneNumberBinding;
import com.myapp.utils.phonenumber.PhoneUtil;

public class PhoneNumberActivity extends BaseActivity<ActivityPhoneNumberBinding> implements View.OnClickListener {


    @Override
    protected void initView() {
        binding.setClick(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_phone_number;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.phone_number_check:
                checkNumber();
                break;
        }
    }

    private void checkNumber() {
        boolean b = PhoneUtil.checkPhoneNumber("17778115595", "1");
        boolean b3 = PhoneUtil.checkPhoneNumber("2028710422", "1");
        boolean b4 = PhoneUtil.checkPhoneNumber("12028710422", "");
        String b1 = PhoneUtil.getCarrier("17778115595", "86");
        String b2 = PhoneUtil.getGeo("17778115595", "86");

    }
}
