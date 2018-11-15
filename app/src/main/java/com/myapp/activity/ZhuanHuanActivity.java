package com.myapp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.myapp.R;
import com.myapp.databinding.ActivityZhuanHuanBinding;
import com.myapp.model.OtherUserBean;
import com.myapp.model.UserBean;
import com.myapp.utils.JSONUtils;

import java.util.ArrayList;

import androidx.databinding.DataBindingUtil;

public class ZhuanHuanActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityZhuanHuanBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_zhuan_huan);
        binding.setClick(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv1:
                UserBean userBean=new UserBean("名字","12");
                Log.i("打印数据1",JSONUtils.objectToJson(userBean));
                OtherUserBean otherUserBean=JSONUtils.jsonToBean(JSONUtils.objectToJson(userBean),OtherUserBean.class);
                Log.i("打印数据2",JSONUtils.objectToJson(otherUserBean));
                Log.i("打印数据3",otherUserBean.toString());
                break;
            case R.id.iv2:
                UserBean[] userBeans=new UserBean[5];
                ArrayList<UserBean> list=new ArrayList<>();
                for (int i=0;i<5;i++){
                    UserBean userBean1=new UserBean("名字"+i,"12");
                    list.add(userBean1);
                    userBeans[i]=userBean1;
                }
                Log.i("打印数据0",JSONUtils.objectToJson(userBeans));
                Log.i("打印数据1",JSONUtils.objectToJson(list));
                ArrayList<OtherUserBean> list1=JSONUtils.object2List(list,OtherUserBean.class);
                Log.i("打印数据2",JSONUtils.objectToJson(list1));
                Log.i("打印数据4",JSONUtils.objectToJson(JSONUtils.objectToBean(list,UserBean[].class)));
                break;
        }
    }
}
