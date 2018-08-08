package com.myapp.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.myapp.R;
import com.myapp.adapter.RecyclerAdapter;
import com.myapp.adapter.RefreshAdapter;
import com.myapp.databinding.ActivityTouchEventBinding;

import java.util.ArrayList;

public class TouchEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTouchEventBinding binding=DataBindingUtil.setContentView(this,R.layout.activity_touch_event);
//        binding.touchLl.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Log.v("view--linealayout","jjjj");
//                return false;
//            }
//        });
//        binding.touchTv.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Log.v("view--textview","jjjj");
//                return false;
//            }
//        });

        binding.touchTv.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<String> list=new ArrayList<>();
        list.add("jfla");
        list.add("jjfa");
        binding.touchTv.setAdapter(new RefreshAdapter(list));
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.v("触摸事件","event"+ev.getAction());
        return super.dispatchTouchEvent(ev);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.v("触摸事件","onTouchEvent"+event.getAction());
        return super.onTouchEvent(event);
    }
}
