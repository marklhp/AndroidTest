package com.myapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.myapp.R;
import com.myapp.base.BaseActivity;
import com.myapp.databinding.ActivityJsonBinding;

import org.json.JSONObject;

import java.util.HashMap;

public class JsonActivity extends BaseActivity<ActivityJsonBinding> implements View.OnClickListener {

    @Override
    protected void initView() {
        binding.setClick(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_json;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.json_tv:
                HashMap<String,Integer> hashMap=new HashMap<>();
                hashMap.put("sr",23);
                hashMap.put("jll",43);
                JSONObject jsonObject = new JSONObject(hashMap);
                Log.d("打印数据",jsonObject.toString());
                
                break;
            case R.id.gson_tv:
                break;
        }
    }
}
