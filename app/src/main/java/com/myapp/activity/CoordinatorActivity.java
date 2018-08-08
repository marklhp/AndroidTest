package com.myapp.activity;

import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.myapp.R;
import com.myapp.adapter.RefreshAdapter;
import com.myapp.databinding.ActivityCoordinatorBinding;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CoordinatorActivity extends AppCompatActivity {
    ArrayList<String> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            final ActivityCoordinatorBinding binding=DataBindingUtil.setContentView(this,R.layout.activity_coordinator);
        for (int i=0;i<20;i++){
            list.add(""+i);
        }
//
//        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
//        binding.recyclerview.setAdapter(new RefreshAdapter(list, new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        }));






        binding.appbarlayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                Log.i("滚动",verticalOffset+"--"+appBarLayout.getHeight());
                BigDecimal b1 = new BigDecimal(Double.toString(verticalOffset+appBarLayout.getHeight()));
                BigDecimal b2 = new BigDecimal(Double.toString(appBarLayout.getHeight()));

                binding.coordinatorTv.setAlpha((float) b1.divide(b2, 3, BigDecimal.ROUND_HALF_UP).doubleValue());
            }
        });

    }
}
