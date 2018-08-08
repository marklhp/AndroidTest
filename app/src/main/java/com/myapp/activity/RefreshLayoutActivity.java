package com.myapp.activity;

import android.databinding.DataBindingUtil;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.myapp.R;
import com.myapp.adapter.RefreshAdapter;
import com.myapp.databinding.ActivityRefreshLayoutBinding;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

public class RefreshLayoutActivity extends AppCompatActivity implements OnRefreshListener, OnLoadMoreListener {
    ArrayList<String> list=new ArrayList();
    RefreshAdapter refreshAdapter;
    ActivityRefreshLayoutBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_layout);
        init();
    }

    private void init() {
        for (int i=0;i<10;i++){
            list.add(""+i);
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_refresh_layout);
        binding.refreshLayoutRv.setLayoutManager(new LinearLayoutManager(this));

        refreshAdapter = new RefreshAdapter(list, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"点击",Toast.LENGTH_SHORT).show();
            }
        });

        binding.refreshLayoutRv.setAdapter(refreshAdapter);
        binding.refreshLayoutSmartrefresh.setOnRefreshListener(this);
        binding.refreshLayoutSmartrefresh.setOnLoadMoreListener(this);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        for (int i=0;i<5;i++){
            list.add(""+i);
        }

        refreshAdapter.notifyDataSetChanged();
        binding.refreshLayoutSmartrefresh.finishRefresh();
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        list.add("加载"+ SystemClock.currentThreadTimeMillis());
        refreshAdapter.notifyDataSetChanged();
        binding.refreshLayoutSmartrefresh.finishLoadMore();
    }
}
