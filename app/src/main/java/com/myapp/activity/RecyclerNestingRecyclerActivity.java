package com.myapp.activity;

import android.app.Activity;
import android.os.Bundle;

import com.myapp.R;
import com.myapp.adapter.RecyclerAdapter;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerNestingRecyclerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_nesting_recycler);
        RecyclerView recyclerView=findViewById(R.id.recyclerview_nesting_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerAdapter());


    }
}
