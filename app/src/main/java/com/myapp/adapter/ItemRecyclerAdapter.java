package com.myapp.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.myapp.App;
import com.myapp.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemRecyclerAdapter extends RecyclerView.Adapter<ItemRecyclerAdapter.ItemRecyclerViewHolder> {
    View.OnClickListener clickListener;

    public ItemRecyclerAdapter(View.OnClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ItemRecyclerAdapter.ItemRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemRecyclerViewHolder(LinearLayout.inflate(App.context,R.layout.item_recyclerview_nesting,null));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemRecyclerAdapter.ItemRecyclerViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onClick(v);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 4;
    }
    static class ItemRecyclerViewHolder extends RecyclerView.ViewHolder{
        public ItemRecyclerViewHolder(View itemView) {
            super(itemView);
        }
    }
}
