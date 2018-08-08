package com.myapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.myapp.App;
import com.myapp.R;

import java.util.ArrayList;

/**
 * Created by lihaipeng on 2018/5/18.
 */

public class RefreshAdapter extends RecyclerView.Adapter<RefreshAdapter.RefreshViewHolder> {
    ArrayList<String> list;
    View.OnClickListener listener;

    public RefreshAdapter(ArrayList<String> list, View.OnClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    public RefreshAdapter(ArrayList list) {
        this.list=list;
    }

    @NonNull
    @Override
    public RefreshViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RefreshViewHolder(LayoutInflater.from(App.context).inflate(R.layout.item_refresh,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RefreshViewHolder holder, int position) {
        holder.textView.setText(list.get(position));
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(App.context));
        holder.recyclerView.setAdapter(new RefreshItemAdapter(listener));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    static class RefreshViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        RecyclerView recyclerView;
        public RefreshViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_refresh);

            recyclerView = itemView.findViewById(R.id.refresh_recycler);
        }
    }
}
