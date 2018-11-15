package com.myapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import com.myapp.App;
import com.myapp.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by lihaipeng on 2018/5/24.
 */

public class RefreshItemAdapter extends RecyclerView.Adapter{
    View.OnClickListener listener;

    public RefreshItemAdapter(View.OnClickListener listener) {
        this.listener=listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(App.context).inflate(R.layout.item_refresh_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return 4;
    }
    static class ItemViewHolder extends RecyclerView.ViewHolder{

        public ItemViewHolder(View itemView) {
            super(itemView);
        }
    }
}
