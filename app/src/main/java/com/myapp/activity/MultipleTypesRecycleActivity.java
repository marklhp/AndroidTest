package com.myapp.activity;

import android.app.Activity;
import android.os.Bundle;

import com.myapp.R;
import com.myapp.adapter.MultipleTypesAdapter;
import com.myapp.databinding.ActivityMultipleTypesRecycleBinding;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

public class MultipleTypesRecycleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMultipleTypesRecycleBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_multiple_types_recycle);
        binding.multipleTypesRv.setLayoutManager(new LinearLayoutManager(this));
        binding.multipleTypesRv.setAdapter(new MultipleTypesAdapter());
    }
}
