package com.myapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.myapp.App;
import com.myapp.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by lihaipeng on 2018/7/9.
 */

public class MultipleTypesAdapter extends RecyclerView.Adapter {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType==0){
            return new OneViewHolder(LayoutInflater.from(App.context).inflate(R.layout.item_one_multiple_type,null));
        }else {
            return new TwoViewHolder(LayoutInflater.from(App.context).inflate(R.layout.item_two_multiple_type,null));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof OneViewHolder){
            ((OneViewHolder)holder).iv.setBackgroundColor(App.context.getResources().getColor(R.color.gray_btn_bg_pressed_color));
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public int getItemViewType(int position) {
        return position%2;
    }

    class OneViewHolder extends RecyclerView.ViewHolder{
        ImageView iv;

        public OneViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.one_multiple_type_iv);
        }
    }
    class TwoViewHolder extends RecyclerView.ViewHolder{

        public TwoViewHolder(View itemView) {
            super(itemView);
        }
    }
}
