package com.myapp.activity;

import android.view.View;
import android.widget.Toast;

import com.myapp.R;
import com.myapp.base.BaseActivity;
import com.myapp.databinding.ActivityDataBindingGlideBinding;


public class DataBinding_Glide_Activity extends BaseActivity<ActivityDataBindingGlideBinding> implements View.OnClickListener {


    @Override
    protected void initView() {
        binding.setResId("");
        binding.setCircleUrl("");
        binding.setGlideClick(this);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_data_binding_glide_;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this,"点击一下",Toast.LENGTH_SHORT).show();
    }
}
