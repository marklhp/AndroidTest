package com.myapp.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.myapp.R;
import com.myapp.adapter.MultipleTypesAdapter;
import com.myapp.databinding.ActivityMultipleTypesRecycleBinding;

public class MultipleTypesRecycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMultipleTypesRecycleBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_multiple_types_recycle);
        binding.multipleTypesRv.setLayoutManager(new LinearLayoutManager(this));
        binding.multipleTypesRv.setAdapter(new MultipleTypesAdapter());
    }
}
