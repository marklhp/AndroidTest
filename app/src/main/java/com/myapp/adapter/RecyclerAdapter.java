package com.myapp.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.myapp.App;
import com.myapp.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    @NonNull
    @Override
    public RecyclerAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LinearLayout.inflate(App.context,R.layout.item_recycler,null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.RecyclerViewHolder holder, int position) {
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(App.context));
        holder.recyclerView.setAdapter(new ItemRecyclerAdapter(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(App.context,"33333",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return 10;
    }
    static class RecyclerViewHolder extends RecyclerView.ViewHolder{
        RecyclerView recyclerView;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.item_recyclerview_nesting_rv);
        }
    }
}
